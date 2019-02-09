package challenge;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import challenge.beans.Players;

public class Main {


    List<Players> players = readListCsv();

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
        players = readListCsv();
		return ((int) players
				.stream()
				.map(Players::getNationality)
				.distinct()
				.count());

	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
        players = readListCsv();
		return ((int) players
				.stream()
				.filter(club -> !club.getClub().isEmpty())
				.map(Players::getClub)
				.distinct()
				.count());
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
        players = readListCsv();
		return (players
				.stream()
				.filter(name -> !name.getFull_name().isEmpty()).limit(20)
				.map(Players::getFull_name).collect(Collectors.toList()));
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
        players = readListCsv();

		return (players.stream()
				.filter(name -> !name.getFull_name().isEmpty())
				.sorted(Comparator.comparing(Players::getEur_release_clause,Comparator.nullsLast(Comparator.reverseOrder())))
				.limit(10)
				.map(Players::getFull_name).collect(Collectors.toList()));
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
        players = readListCsv();

        return (players.stream()
                .filter(name -> !name.getFull_name().isEmpty())
                .sorted(Comparator.comparing(Players::getBirth_date).thenComparingDouble(Players::getEur_wage))
                .limit(10)
                .map(Players::getFull_name).collect(Collectors.toList()));
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
        players = readListCsv();

	    List<Integer> idades = players.stream().mapToInt(p->p.getAge()).distinct().boxed().collect(Collectors.toList());
        Map<Integer,Integer> mapaIdade = idades.stream().collect(
                Collectors.toMap(Function.identity(), e -> (int)players.stream().filter(p->p.getAge()==e).count()));
		return mapaIdade;
	}

	public List<Players> readListCsv() {

	    if(players==null){
            players = new ArrayList<>();
        }
	    else{
	        return players;
        }
		try {

            InputStream resourceStream  =
                    Players.class.getResourceAsStream("/data.csv");

            BufferedReader reading = new BufferedReader(new InputStreamReader(resourceStream));
            String[] lines = reading.lines().toArray(String[]::new);
            lines = Arrays.copyOfRange(lines, 1, lines.length);
			Locale in_ID = new Locale("en","US");
			DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(in_ID);
			nf.setParseBigDecimal(true);
			for(String line : lines){
                String[] values = line.split(",");

                BigDecimal bd = BigDecimal.ZERO;
                Double doubleValue = new Double(0);
                Integer integerValue = new Integer(0);
                LocalDate localDateValue = LocalDate.now();
                try {
                    bd = (BigDecimal)nf.parse(values[18], new ParsePosition(0));
                    doubleValue = Double.valueOf(values[17]);
                    localDateValue = LocalDate.parse(values[8]);
                    integerValue = Integer.parseInt(values[6]);

                }catch (Exception e){
                }
                Players player =
                        new Players(values[0], values[1], values[2], values[14], values[3],
                                bd
                                , doubleValue, localDateValue, integerValue);

                players.add(player);

            }


		} catch (Exception e) {
            e.printStackTrace();
		}

		return players;

	}

}