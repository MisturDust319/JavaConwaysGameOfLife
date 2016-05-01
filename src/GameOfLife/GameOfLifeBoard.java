package GameOfLife;

import board.Board;

public class GameOfLifeBoard extends Board<LifeNode> {
	GameOfLifeBoard() {
		//calls the default superclass (the Board class) constructor
		super();
		
		//find the neighbors for each node in the board
		for(int i = 0; i < this.getLength(); i++) {
			for(int j = 0; i < this.getWidth(); j++) {
				if( i == 0 ) {
					this.board[i][j].addNeighbor(this.board[i+1][j]);
				}
			}
		}
	}
	
	GameOfLifeBoard(int aWidth, int aLength) {
		//calls the custom board length
		//	superclass (the Board class) constructor
		super(aWidth, aLength);
	}
}
