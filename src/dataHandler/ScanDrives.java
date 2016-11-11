package dataHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Vector;

public class ScanDrives {
	
	File[] drives;
	
	public ScanDrives() {
		drives = new File("root").listRoots();
		for (File file : drives) {
			String serial = null;
			String string =  file.getAbsolutePath();
			try {
				serial = getSerialKey(string.charAt(0));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
	public static String getSerialKey(Character letter) throws Exception{
        String line = null;
        String serial = null;
        Process process = Runtime.getRuntime().exec("cmd /c vol "+letter+":");
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()) );
        while ((line = in.readLine()) != null) {
            if(line.toLowerCase().contains("serial number")){
                String[] strings = line.split(" ");
                serial = strings[strings.length-1];
            }
        }
        in.close();
        return serial;
    }
}
