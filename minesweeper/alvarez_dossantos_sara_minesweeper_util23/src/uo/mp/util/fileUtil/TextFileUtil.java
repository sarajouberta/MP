package uo.mp.util.fileUtil;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * A utility class to read/write text lines from/to a text file
 */
public class TextFileUtil extends BaseFileUtil {

	@Override
	protected BufferedReader createReaderChain(String name) throws FileNotFoundException {
		try {
			return new BufferedReader(new FileReader(name));    //revisar
		}catch(IOException e) {
			throw new FileNotFoundException();
		}
	}

	@Override
	protected BufferedWriter createWriterChain(String name) throws IOException {
		try {
			return new BufferedWriter(new FileWriter(name));   //revisar
		}catch(IOException e) {
			throw new RuntimeException("error de escritura en fichero" + name + e.getMessage());     
		}
	}
	

}
