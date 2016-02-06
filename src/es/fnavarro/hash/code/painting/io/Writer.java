package es.fnavarro.hash.code.painting.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

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

	private void getLines() throws IOException {
		
		writer.write("PAINT_LINE 1 2");
		newLine();
	}

	private void getSquares() throws IOException {
		
		writer.write("PAINT_LINE 1 2");
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
