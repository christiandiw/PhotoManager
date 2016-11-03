package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadConfigFile {
	
	private final String firstProjectPath = "@FirstProjectPath:";
	private final String secondProjectPath ="@SecondProjectPath:";
	private final String fileEndings = "@ParseFileEndings:";
	private final String comment = "#";

	public ReadConfigFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(GlobalVariables.CONFIG_FILE))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if (!line.startsWith(comment) && line.length() > 0) {
		    		line = line.trim();
		    		line = line.replaceAll("\\s+","");
		    		parseLine(line);					
				}
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseLine(String string) {
		parseFirstPath(string);
		parseSecondPath(string);
		parseFileEndings(string);
		
	}

	private void parseFileEndings(String string) {
		if (string.contains(fileEndings)) {
			String tmpString = string.substring(fileEndings.length(), string.length());
			GlobalVariables.FILE_ENDINGS = tmpString.split(";");

		}
		
	}

	private void parseSecondPath(String string) {
		if (string.contains(secondProjectPath)) {
			GlobalVariables.IEC_PATH_FIRST = string.substring(secondProjectPath.length(), string.length());
		}
		
	}

	private void parseFirstPath(String string) {
		if (string.contains(firstProjectPath)) {
			GlobalVariables.IEC_PATH_FIRST = string.substring(firstProjectPath.length(), string.length());	
		}
		
	}
	
}
