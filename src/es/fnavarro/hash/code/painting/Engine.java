package es.fnavarro.hash.code.painting;

import java.io.File;

import es.fnavarro.hash.code.painting.domain.Document;
import es.fnavarro.hash.code.painting.io.Reader;

public class Engine {
	
	private Document document;
	private File file;

	public static void main (String args[]) throws Exception{
		File f = parseInputArgs(args);
		new Engine(f).read().write();
	}

	private static File parseInputArgs(String[] args) throws Exception{
		
		if(args.length==0){
			throw new Exception("One file as argument must to be provided");
		}
		
		File f = new File(args[0]);
		
		if(!f.exists()){
			throw new Exception("The file "+f.getAbsolutePath()+" does not exist.");
		}
		
		return f;
	}
	
	public Engine(File file){
		this.file = file;
	}
	
	public Engine read() throws Exception{
		this.document = Reader.read(file);
		return this;
	}
	
	public void write(){
		
		
	}
	
}
