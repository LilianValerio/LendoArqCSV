package challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import challenge.beans.Players;

public class Main {
	
	

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		List<Players> players = readListCsv();
		
		return ((int) players
				.stream()
				.map(Players::getNationality)
				.distinct()
				.count());
		
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		List<Players> players = readListCsv();
		return ((int) players
				.stream()
				.filter(club -> !club.getClub().isEmpty())
				.map(Players::getClub)
				.distinct()
				.count());
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<Players> players = readListCsv();

		return (players
				.stream()
				.filter(name -> !name.getFull_name().isEmpty()).limit(20)
				.map(Players::getFull_name).collect(Collectors.toList()));	
		}
		
	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		List<Players> players = readListCsv();

		//falta transforma o getur em integer, senao a logica nao compara
		
		return (players.stream()
				.filter(name -> !name.getFull_name().isEmpty())
				.sorted(Comparator.comparing(Players::getEur_release_clause).reversed())
				.limit(10)
				.map(Players::getFull_name).collect(Collectors.toList()));	
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
		 
         List<Players> players = new ArrayList<>();
				                                    
         try {
        	String linesArchive = new String(); 
        	File archiveCsv = new File("src/main/resources/data.csv");
			Scanner reading = new Scanner(archiveCsv);
			
			int id = 0;
			reading.nextLine();
			while(reading.hasNext()) {
				
				linesArchive = reading.nextLine();
				String[] values = linesArchive.split(",");
				Players player =
				new Players(values[0], values[1], values[2], values[14], values[3], new BigDecimal(values[18])
						, (new Double(values[17])), (LocalDate.parse(values[8])), (Integer.parseInt(values[6])));
				
				players.add(player);
				id = id+1;
				System.out.println(id);
			}
	
		} catch (FileNotFoundException e) {
		
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
		
		
		
	 System.out.println("teste 1 - " + teste1);
		 System.out.println("teste 2 - " + teste2);
	 System.out.println("teste 3 - " + teste3);
		 System.out.println("teste 4 - " + teste4);
		 System.out.println("teste 5 - " + teste5);
		 System.out.println("teste 6 - " + teste6);
	}
}
