package uo.mp.lab.util.log;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import uo.mp.util.fileUtil.BaseFileUtil;
import uo.mp.util.fileUtil.TextFileUtil;

public class FileLogger implements SimpleLogger{

	private BaseFileUtil bs = new TextFileUtil();
	private String fileLoggerName;
	
	public FileLogger(String fileLoggerName) {
		this.fileLoggerName = fileLoggerName;
	}
	
	/**
	 * Registra la excepción guardando su información en el archivo .log
	 */
	@Override
	public void log(Exception ex) {
		String logLine = exceptionToLogFormat(ex.getMessage());
		List<String> logLines = new ArrayList<String>();
		logLines.add(logLine);
		bs.writeLines(fileLoggerName, logLines);  //REVISAR: recibe una lista
	}

	/*
	 * Para convertir el mensaje de la excepción al formato indicado:
	 * 
	 */
	private String exceptionToLogFormat(String message) {
		StringBuilder str = new StringBuilder();
		Date d = new Date(System.currentTimeMillis());
		String date = new SimpleDateFormat("dd/MM/yy").format(d) ;
		String hour = new SimpleDateFormat("HH:mm:ss").format(d);
		str.append("[" + date + "-" + hour + "]:Error de I/O. ");
		str.append(message);
		return str.toString();
	}
	
}
