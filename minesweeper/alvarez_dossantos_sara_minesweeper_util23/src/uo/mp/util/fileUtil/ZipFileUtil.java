package uo.mp.util.fileUtil;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;


/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil extends BaseFileUtil{
	
    //método de la superclase que quedará al refactorizar el código
	
	// R E V I S A R
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	protected BufferedReader createReaderChain(String name) throws FileNotFoundException {
		try {
			return new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(name))));
		}catch(IOException e) {
			throw new FileNotFoundException();
		}
	}

	@Override
	protected BufferedWriter createWriterChain(String name) throws IOException {
		try {
			return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name)));
		}catch(IOException e) {
			throw new RuntimeException(e);     //revisar
		}
	}




//	public List<String> readLines(String inFileName) throws FileNotFoundException {
//		ArgumentChecks.isTrue(inFileName != null && !inFileName.isBlank());
//		List<String> lines = new ArrayList<>();
//		
//		try {
//			BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(inFileName))));
//			
//			try {
//				while(in.ready()) {
//					lines.add(in.readLine());
//				}
//			}finally {
//				in.close();
//			}
//			//propaga la excepción para que informe al usuario, no termine el programa (IO = superclase)
//		}catch(FileNotFoundException e){   //distinguir entre estas dos excepciones para que no lanze IO y finalice el progr
//			throw e;
//		}catch(IOException e) {
//			throw new RuntimeException("error de lectura en fichero" + inFileName + e.getMessage());
//		}
//		return lines;
//	}
	

	
//	public void writeLines(String outZippedFileName, List<String> lines) {
//		ArgumentChecks.isTrue(outZippedFileName != null && !outZippedFileName.isBlank());
//		ArgumentChecks.isTrue(lines != null);
//		
//		try {
//			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outZippedFileName)));
//			
//			try {
//				for(String line : lines) {
//					out.write(line);
//					out.newLine(); //salto de linea
//				}
//			}finally {
//				out.close();
//			}
//		}catch(IOException e) {
//			throw new RuntimeException("error de lectura en fichero" + outZippedFileName + e.getMessage());
//		}
//	}

}
