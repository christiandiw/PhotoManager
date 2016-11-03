package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFile {

	private static LogFile instance = null;
	private String logFilePath =" BrowseSVAttribute.log";
	private PrintWriter writer = null;
	
	public static LogFile getInstance() {
		if (instance == null) {
			instance = new LogFile();
		}
		return instance;
	}
	
	public LogFile() {
		File file = new File(logFilePath);
		if (file.exists()) {
			file.delete();
		}
	}


	
	public void writeLine (String string) {
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(getTime() + " " + string);	
		writer.flush();
		writer.close();
	}


	private String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(); //2014/08/06 15:59:48
		return dateFormat.format(date);
	}
}
