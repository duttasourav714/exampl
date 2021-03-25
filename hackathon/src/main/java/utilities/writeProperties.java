package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class writeProperties {
	
	//Method writing the properties file used to store the output
	public static void writingfile(ArrayList<String> models) { //method to write in properties file
		
		Properties prop1 = new Properties();
		OutputStream writeFile = null;
		try {
			writeFile = new FileOutputStream("Honda.properties");
	
			for (int i=0; i<models.size();i++)
			{
				int j = i+1;
				String keyString = Integer.toString(j);
				prop1.setProperty(keyString, models.get(i));
			}
			prop1.store(writeFile,null);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			if(writeFile != null) {
				try {
					writeFile.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		}
	}

}
