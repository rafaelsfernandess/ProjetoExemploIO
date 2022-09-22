import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

public class Listagem {

	public Listagem() {
		
/*		
 	File f = new File("C:/Users/rafael.fernandes3/Downloads/Exemplo.txt");
	File fd = new File("C:/Users/rafael.fernandes3/Downloads/");
	System.out.println(f.isFile());
	System.out.println(fd.isFile());
	System.out.println("------");
	System.out.println(f.isDirectory());
	System.out.println(fd.isDirectory());
*/		
		
		
/*	if(f.isFile()) {
			if(f.exists()) {
				f.delete();
			}
		}
	}
*/	
		
		File raiz = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int option = fileChooser.showOpenDialog(null);
		
		if(option == JFileChooser.APPROVE_OPTION) {
			raiz = fileChooser.getSelectedFile();
			//System.out.println(raiz.getAbsolutePath()); //Busca o caminho absoluto
			//System.out.println(raiz); // Pega o nome do arquivo
			lerDiretorio(raiz);
		}else {
			JOptionPane.showMessageDialog(null, "O programa não pode continuar"+"Faltou selecionar um diretório válido");
		}	
}

	private void lerDiretorio(File dir) {
		File[] listagem = dir.listFiles();
		
		for(File file  : listagem) {
			System.out.println(">>>>"+file.getAbsolutePath());
			if(file.isDirectory()) {
				System.out.println("Diretório");
				lerDiretorio(file);
			}else {
				System.out.println("É um arquivo");
				
				/*
				File novoArquivo = new File("C:\\Users\\rafael.fernandes3\\Downloads\\CLIENTE1\\NOVODIRET\\"+file.getName());
				
				file.renameTo(novoArquivo);
				*/
				
				File arquivoDestino = new File("C:\\Users\\rafael.fernandes3\\Downloads\\ArquivosCopiados\\"+file.getName());
				/*
				try {
					copy(file, arquivoDestino);
				}catch(IOException e) {
					e.printStackTrace();
				}
				*/
				try {
				FileUtils.copyFile(file, arquivoDestino);
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	private void copy(File src, File dest) throws IOException{
		InputStream is = null;
		OutputStream os = null;
		
		try {
			
			is = new FileInputStream(src);
			os= new FileOutputStream(dest);
			
			//buffer sizer 1k
			byte[]buf= new byte[1024];
			
			int bytesRead;
			while((bytesRead = is.read(buf))>0) {
				os.write(buf, 0, bytesRead);
			}
			
		} finally {
			is.close();
			os.close();
		}
	}
	
	public static void main(String[] args) {

		Listagem l = new Listagem();

	}

}
