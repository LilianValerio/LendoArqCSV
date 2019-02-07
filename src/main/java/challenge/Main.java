package challenge;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Main {

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return 0;
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return 0;
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return null;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return null;
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
	
	public void lerListaCSV() {
		 Reader reader;
		try {
			
			reader = Files.newBufferedReader(Paths.get("src/main/resources/data.csv"));
			 CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		        List<String[]> pessoas = csvReader.readAll();
		      int tamanho  = pessoas.size();
		      for (String[] pessoa : pessoas) {
		            System.out.println("id : " + pessoa[0] +
		                            " - name : " + pessoa[1] +
		                            " - full_name : " + pessoa[3]
		                            );
		    }  
		      
		} catch (IOException e) {
			e.printStackTrace();
		}
	       
	}
	
	public static void main(String[] args){
		
		Main main = new Main();
		main.lerListaCSV();
	}
}