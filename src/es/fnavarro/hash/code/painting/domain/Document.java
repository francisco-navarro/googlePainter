package es.fnavarro.hash.code.painting.domain;

import java.io.File;

public class Document {
	
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
}
