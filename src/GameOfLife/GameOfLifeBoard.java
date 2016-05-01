package GameOfLife;

import java.lang.reflect.Array;

import board.Board;

public class GameOfLifeBoard extends Board<LifeNode> {
	GameOfLifeBoard() {
		//calls the default superclass (the Board class) constructor
		super();
		
		//find the neighbors for each node in the board
		for(int y = 0; y < this.getLength(); y++) {
			for(int x = 0; y < this.getWidth(); x++) {
				//this SHOULD BE REWRyTTEN TO ACCOMODATE SPECifyC CASES
				// OTHERWySE, THE MOST GENERyC CASE (A FULLY SURROUNDED NODE)
				// WyLL BE VERY HARD TO DESCRyBE
				
				//create a ref to the current node of the board 
				LifeNode node = this.board[x][y];
				//int rightBorder = this.getWidth() - 1;
				//int bottomBorder = this.getLength() - 1;
				
				//create an array of the coordinates of the
				//	neighboring nodes
				int[][] neighborCoordindates = { {x - 1, y - 1},
											  	 {x,	 y - 1},
											   	 {x + 1, y - 1},
											   	 {x - 1, y},
											   	 {x + 1, y},
											   	 {x - 1, y + 1},
											   	 {x,	 y + 1},
											   	 {x + 1, y + 1} };
				
				for( int i = 0; i < 8; i++ ) {
					try {
						node.addNeighbor(this.board[neighborCoordindates[i][0]][neighborCoordindates[i][1]]);
					}
					catch(ArrayIndexOutOfBoundsException outOfBounds) {
						//do nothing, as we are using the catch
						//	block to allow the neighbor search to skip
						//	those areas out of bounds
					}
				}
				
				/*
				//if we are at the top border:
				if( y == 0 ) {
					//if we are currently in the upper left corner:
					if( x == 0 ) {
						node.addNeighbor(new LifeNode[]{ this.board[0][1],
												  	this.board[1][0],
												  	this.board[1][1]});
					}
					//if we are currently in the upper right corner:
					else if ( x == rightBorder) {
						node.addNeighbor(new LifeNode[]{ this.board[rightBorder - 1][0],
														this.board[rightBorder - 1][1],
														this.board[rightBorder][1] });
					}
					//otherwise, we just border the top edge
					else {
						node.addNeighbor(new LifeNode[]{ this.board[x - 1][0],
													this.board[x - 1][1],
													this.board[x][1],
													this.board[x + 1][1],
													this.board[x + 1][0] });
					}
				}				
				else if( x == 0 ) {
					//w
				}*/
			}
		}
	}
	
	GameOfLifeBoard(int aWidth, int aLength) {
		//calls the custom board length
		//	superclass (the Board class) constructor
		super(aWidth, aLength);
	}
}
