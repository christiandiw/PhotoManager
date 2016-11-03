package application;
	
import java.io.File;
import java.util.Vector;

import dataHandler.ReadData;
import javafx.application.Application;
import javafx.stage.Stage;
import sun.security.util.Length;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Vector<File> fileCollection1;
	
	@Override
	public void start(Stage primaryStage) {
		
		//Read all files with defined endings
		fileCollection1 = new ReadData().execute(GlobalVariables.IEC_PATH_FIRST);
	
		//Parse each file and collect attributes
		
		
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
