package com.gedcom.parser.core;

import java.io.BufferedReader;
import java.io.FileReader;

public class GedcomParser {
	
	public static void main(String[] args) {
		
		try{
						
			String buffer = new String();
			DataCache dataCache = new DataCache();
			
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			System.out.println("Begin Parsing ...\n");
			
			while((buffer = in.readLine()) != null)	dataCache.processBuffer(buffer);				
			in.close();
			
			System.out.println("Writing to " + args[1] + "\n");
			XmlWriter xmlWriter = new XmlWriter(args[1]);
			xmlWriter.writeXml(dataCache);
			
			System.out.println("End Parsing.");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}				
		
	}

}
