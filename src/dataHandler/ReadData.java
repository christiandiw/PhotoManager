package dataHandler;

import java.io.File;
import java.util.Vector;

import application.GlobalVariables;
import application.LogFile;

public class ReadData {
	
	private Vector<File> fileCollection;

	public Vector<File> execute(String path) {
		File file = new File(path);
		fileCollection = new Vector<File>();
		if (file.exists() && file.isDirectory()) {
			parseFiles(file);
		} else {
			LogFile.getInstance().writeLine("File " + file + " does not exist or is no directory");
		}
		return fileCollection;
	}

	private void parseFiles(File file) {
		File[] fileList = file.listFiles();
		for (File fileChild : fileList) {
			if (fileChild.isDirectory()) {
				parseFiles(fileChild);
			} else {
				for (String ending : GlobalVariables.FILE_ENDINGS) {
					if (fileChild.getAbsolutePath().endsWith(ending)) {
						LogFile.getInstance().writeLine(fileChild.getPath());
						fileCollection.addElement(fileChild);
					}	
				}
			}
		}
	}
}
