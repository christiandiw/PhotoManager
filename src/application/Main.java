package application;
	
import java.io.File;
import java.util.Vector;

import dataHandler.ScanDrives;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
	
		new ScanDrives();

	}
	
	/*
	 * args[0] config file path (mandatory)
	 *  
	 */
	public static void main(String[] args) {
		
		int nbrArgs = args.length;
		
		if (nbrArgs >= 1) {
			GlobalVariables.CONFIG_FILE = args[0];
			LogFile.getInstance().writeLine("Configuration file path found " + GlobalVariables.CONFIG_FILE);
		} else {
			LogFile.getInstance().writeLine("No configuration file path input at arg0. Use a path.");
			System.exit(0);
		}
		
		new ReadConfigFile();
			
		launch(args);
	}
}
