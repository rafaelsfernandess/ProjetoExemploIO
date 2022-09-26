import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivoTexto {

	public LeituraArquivoTexto() {

		File arquivoCSV = new File("C:\\Users\\rafael.fernandes3\\Downloads\\mix-mercado.csv");

		try {

			FileReader fileReader = new FileReader(arquivoCSV);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String linha = null;
			int numLinha = 0;
			while ((linha = bufferedReader.readLine()) != null) {
				numLinha++;
				if (numLinha != 1) {
					
					String vetor[] = linha.split(";");
					
					System.out.println("");
					System.out.println("\t"+"nome: "+vetor[1].trim().replaceAll("\s+"," "));
					System.out.println("\t"+"Código de barras: "+vetor[2].trim());
					System.out.println("");
					System.out.println("|-------------------------------------------------------------|");
					
				}
			}

			fileReader.close();
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		LeituraArquivoTexto leitura = new LeituraArquivoTexto();
	}

}
