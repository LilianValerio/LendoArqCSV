package challenge;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import challenge.beans.Players;

public class Main {
	
	

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		List<Players> players = readListCsv();
		
		return ((int) players.stream()
				.map(Players::getNationality)
				.distinct()
				.count());
		
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		List<Players> players = readListCsv();
		return ((int) players.stream().filter(club -> !club.getClub().isEmpty())
				.map(Players::getClub)
				.distinct()
				.count());
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<Players> players = readListCsv();
		
		return players.stream().filter(player -> !player.getFull_name().isEmpty())
				.map(Players::getFull_name)
				.limit(20)
				.collect(Collectors.toList());
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		List<Players> players = readListCsv();
		return players.stream().filter(player -> !player.getFull_name().isEmpty() && !player.getEur_release_clause().isEmpty())
				.sorted()
				.map(Players::getFull_name)
				.limit(10)
				.collect(Collectors.toList());
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return null;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return null;
	}
	
	public List<Players> readListCsv() {
		 
		Reader reader;
		 List<Players> players= null; 
		try {
			reader = Files.newBufferedReader(Paths.get("src/main/resources/data.csv"));
			  CsvToBean<Players> csvToBean = new CsvToBeanBuilder(reader)
		                .withType(Players.class)
		                .build();

		         players = csvToBean.parse();

		        for (Players player : players) {
		            System.out.println(player);
		        }
		} catch (IOException e) {
			 System.out.println("erro ao popular a Lista");
		}
		
	      return players;
	       
	}
	
	public static void main(String[] args){
		
		Main main = new Main();
		int teste1 = main.q1();
		int teste2 = main.q2();
		List<String> teste3 = main.q3();
		List<String> teste4 = main.q4();
		List<String> teste5 = main.q5();
		Map<Integer, Integer> teste6 = main.q6();
		
//		 System.out.println("teste 1 - " + teste1);
//		 System.out.println("teste 2 - " + teste2);
//		 System.out.println("teste 3 - " + teste3);
//		 System.out.println("teste 4 - " + teste4);
//		 System.out.println("teste 5 - " + teste5);
//		 System.out.println("teste 6 - " + teste6);
	}
}
