package es.fnavarro.hash.code.painting.domain;

import java.io.Serializable;

public class Document implements Serializable{
	
	private int totalCols;
	private int totalRows;
	

	
	private boolean[][]  rows;
	
	
	public Document(int rows, int cols){
		totalCols = cols;
		totalRows = rows;
		this.rows = new boolean[rows][cols];
	}


	public int getTotalCols() {
		return totalCols;
	}


	public void setTotalCols(int totalCols) {
		this.totalCols = totalCols;
	}


	public int getTotalRows() {
		return totalRows;
	}


	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	
	public void fillLine(int i, boolean[] line) {
		rows[i] = line.clone();
	}
	
	public boolean get(int row,int col){
		return rows[row][col];
	}

	public void deleteLine(int r1,int c1, int r2, int c2){
		
	}


	public void deleteSquare(int i, int j, int s) {
		for (int a = i - s; a <= i + s; a++) {
			for (int b = j - s; b <= j + s; b++) {
				rows[a][b]= false;						
			}
		}
	}
	
	public String toString(){
		String result ="";
		for (int i=0;i<totalRows;i++){
			for(int j=0;j<totalCols;j++){
				result+=rows[i][j]?'#':'_';
			}
			result+="\n";
		}
		return result;
	}
}
