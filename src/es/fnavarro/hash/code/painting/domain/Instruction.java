package es.fnavarro.hash.code.painting.domain;

public enum Instruction {

	
	SQUARE(1,"PAINT_SQUARE # # #"),
	LINE(2, "PAINT_LINE # # # #"),
	ERASE(3, "ERASE_CELL # #");
	
	private byte value;
	private String description;
	
	
	private Instruction (int value, String description){
		this.value=(byte) value;
		this.description = description;
	}
	
	public byte value(){
		return value;
	}
	
	public String toString(String args[]){
		String instruction = description;
		for(String arg : args ){
			instruction.replaceFirst("#", arg);
		}
		return instruction;
	}
}
