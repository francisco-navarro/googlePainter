package es.fnavarro.hash.code.painting.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import es.fnavarro.hash.code.painting.domain.Document;

public class Reader {
	
	

	public static Document read(File f) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(f));
		
		String line = reader.readLine();
		int rows = Integer.parseInt(line.split(" ")[0]);
		int cols = Integer.parseInt(line.split(" ")[1]);
		
		System.out.println( "Reading file "+f.getAbsolutePath()+"\n\t rows: "+rows+" cols: "+cols);
		Document document = new Document(rows, cols);
		
		
		return document;
	}
	


}
