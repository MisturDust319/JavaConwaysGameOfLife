//create a generic board object
package board;

import draw.Draw;

public class Board<T> implements Draw {
	private T[][] board;
	private int length, width;
	
	//default constructor
	//	makes a 8*8 board
	public Board() {
		length = width = 8;
		board = (T[][]) new Object [8][8];
	}
	
	//constructor which creates a custom size board
	public Board(int aWidth, int aLength) {
		length = aLength; 
		width = aWidth;
		board = (T[][]) new Object [aWidth][aLength];
	}
	
	public void draw() {
		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j < this.length; j++) {
				System.out.println(board[i][j]);
			}
		}
	}
}
