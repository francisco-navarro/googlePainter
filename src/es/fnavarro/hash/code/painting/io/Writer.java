package es.fnavarro.hash.code.painting.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import es.fnavarro.hash.code.painting.domain.Document;

public class Writer {
	
	private Document document;
	private int countInstructions = 0;
	private File output;
	FileWriter writer = null;

	public Writer(Document document, File output) {
		this.document = document;
		this.output = output;
	}
	
	public void write() throws Exception {
		
		try{
			writer = new FileWriter(output);
			getSquares();
			getLines();
			
		}finally{			
			if(writer!=null){
				writer.close();
			}
		}
		finalizeFirstLine();
	}

	private void getLines() throws Exception {
		int endLine = 0;
		for(int i = 0; i<document.getTotalRows(); i++){
			for (int j=0;j<document.getTotalCols();j++){
				
				while(j<document.getTotalCols() && !document.get(i, j)){
					j++;
				}
				//Find next true				
				if(j<document.getTotalCols() && document.get(i, j)){
					endLine=j;
					while(endLine<document.getTotalCols() && document.get(i, endLine)){
						endLine++;
					}
					writeLine(i, j, i, --endLine);
					j=endLine;
				}				
			}
		}
		//TODO: do vertical and horizontal and compare
		
	}
	
	private void writeLine(int r1,int c1,int r2,int c2)throws Exception{
		countInstructions++;
		writer.write("PAINT_LINE ");
		writer.write(r1 + " "+ c1+" " + r2 + " "+ c2);
		newLine();
	}

	private void getSquares() throws Exception {
		
		//ArrayList<int[]> squares = 
				
		for(int i = 1; i<document.getTotalRows(); i++){
			for (int j=1;j<document.getTotalCols(); j++){
				if(document.get(i, j)){
					//Compruebo si tiene mas de un area de 2, y pinto
					int s=1;
					while(j+(s*2) < document.getTotalCols() && checkArea(i,j,s)){
						System.out.println("Have area "+i+" "+j+" "+s);
						s++;
					}
					s--;
					if(s>0){
						writeSquare(i, j, s);
						document.deleteSquare(i,j,s);
						j+=s;
					}
					
				}
			}
		}
		
	}

	private boolean checkArea(int r, int c, int s) {
		try {
			for (int a = r - s; a <= r + s; a++) {
				for (int b = c - s; b <= c + s; b++) {
					if (!document.get(a, b)){
						return false;
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	private void writeSquare(int r, int c, int s) throws Exception{
		countInstructions++;
		writer.write("PAINT_SQUARE ");
		writer.write(r + " "+ c+" " + s );
		newLine();
	}
	
	private void newLine() throws IOException{
		writer.write('\n');
	}

	private void finalizeFirstLine() throws Exception {

		RandomAccessFile f = new RandomAccessFile(output, "rw");
		f.setLength(f.length() - 1);// Delete last char
		f.close();
		
		String[] cmd = { "/bin/sh", "-c", "echo " + countInstructions + " > solution.out" };
		Process p = Runtime.getRuntime().exec(cmd);
		p.waitFor();
		cmd[2] =  "cat " + output.getAbsolutePath() + " >> solution.out" ;
		p = Runtime.getRuntime().exec(cmd);
		p.waitFor();

	}

}
