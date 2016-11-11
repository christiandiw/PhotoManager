package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadConfigFile {
	
	private final String targetPath = "@TargetPath:";
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
		parseTargetPath(string);
		
	}

	private void parseTargetPath(String string) {
		if (string.contains(targetPath)) {
			String tmpString = string.substring(targetPath.length(), string.length());
			GlobalVariables.FILE_ENDINGS = tmpString.split(";");

		}
		
	}


}
