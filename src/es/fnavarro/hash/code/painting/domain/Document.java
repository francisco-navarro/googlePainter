package es.fnavarro.hash.code.painting.domain;

import java.io.File;

public class Document {
	
	private int totalCols;
	private int totalRows;
	

	
	private boolean[][]  cols;
	
	
	public Document(int rows, int cols){
		totalCols = cols;
		totalRows = rows;
		this.cols = new boolean[rows][cols];
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


	public boolean[][] getCols() {
		return cols;
	}


	public void setCols(boolean[][] cols) {
		this.cols = cols;
	}

	
}
