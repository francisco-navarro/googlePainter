package es.fnavarro.hash.code.painting.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import es.fnavarro.hash.code.painting.domain.Document;

public class Reader {
	
	
	private static boolean[] buffer;
	
	public static Document read(File f) throws Exception {
		
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new FileReader(f));
			
			String line = reader.readLine();
			int rows = Integer.parseInt(line.split(" ")[0]);
			int cols = Integer.parseInt(line.split(" ")[1]);
			buffer = new boolean[cols];
			int currentRow = 0;
			
			System.out.println( "Reading file "+f.getAbsolutePath()+"\n\t rows: "+rows+" cols: "+cols);
			Document document = new Document(rows, cols);
			
			while((line=reader.readLine())!=null){
				document.fillLine(currentRow++, parseLine(line.toCharArray()));
			}
			
			return document;
			
		}finally{
			reader.close();
		}
		
		
	}

	private static int i;
	private static boolean[] parseLine(char[] cs) {
		
		for(i=0; i< buffer.length;i++){
			buffer[i] = cs[i] == '#';	
		}			
		return buffer;
	}
	


}
