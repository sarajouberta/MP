package uo.mp.util.fileUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;

public abstract class BaseFileUtil {

	public BaseFileUtil() {
		super();
	}

	public List<String> readLines(String inFileName) throws FileNotFoundException {
		ArgumentChecks.isTrue(inFileName != null && !inFileName.isBlank(), "Error en nombre de fichero");  
		List<String> res = new LinkedList<>();
		
		BufferedReader in = createReaderChain(inFileName);
		//2- leer linea a linea 
		try {
			try {
				String line;
				while((line = in.readLine()) != null) {
					res.add(line);
				}
			}finally {   //3- simepre se cierra fichero
				in.close();
			}
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		return res;
		
	}

	public void writeLines(String outFileName, List<String> lines) {
		ArgumentChecks.isTrue(outFileName != null && !outFileName.isBlank());
		ArgumentChecks.isTrue(lines != null);
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
			try {
				for(String line : lines) {
					out.write(line);
					out.newLine(); //salto de linea
				}
			}finally {
				out.close();
			}
		}catch(IOException e) {
			throw new RuntimeException("error de lectura en fichero" + outFileName + e.getMessage());
		}
	}
	
	protected abstract BufferedReader createReaderChain(String name) throws FileNotFoundException;
	protected abstract BufferedWriter createWriterChain(String name) throws IOException;
}