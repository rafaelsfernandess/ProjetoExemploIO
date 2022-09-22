import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class EscritaArquivoTexto {

	public EscritaArquivoTexto() {
		
		File arquivoTextoDestino = new File("C:\\Users\\rafael.fernandes3\\Downloads\\meuarquivo.txt");
		
	try {
		OutputStream outputStream = new FileOutputStream(arquivoTextoDestino);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		
		PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);
		
		for(int i =0; i<Integer.MAX_VALUE;i++) {
			printWriter.println("Linha com o valor "+i);
			System.out.println("Linha com o valor "+i);
		}
		
		outputStream.close();
		outputStreamWriter.close();
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public static void main(String[] args) {
			
		EscritaArquivoTexto escritaArquivoTexto = new EscritaArquivoTexto();

	}

}
