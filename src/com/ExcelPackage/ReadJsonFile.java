package com.ExcelPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile {

		public static boolean getBooleanFromString(String strict){
			if(strict.toLowerCase().trim().equals("true")){
		    	return true;
		    }
			return false;
		}

	public static String readJsonFile(String value) throws FileNotFoundException {
			String sCurrentLine;
			String jsonFile = "";		     
			try (BufferedReader br = new BufferedReader(new FileReader(value)))
			{
				while ((sCurrentLine = br.readLine()) != null) {
					jsonFile += sCurrentLine;
				}
		
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			return jsonFile; 
		
		
		}
	}



	
