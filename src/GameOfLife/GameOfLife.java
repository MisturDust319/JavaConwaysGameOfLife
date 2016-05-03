
package GameOfLife;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameOfLifeBoard board = new GameOfLifeBoard();
		board.draw();
	}

}

//interface to implement Draw function
interface Draw {
	public void draw();
}


class Board<T> implements Draw {
	protected T[][] board;
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
	
	//display the contents of the board
	public void draw() {
		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j < this.length; j++) {
				System.out.println(board[i][j]);
			}
		}
	}
	
	//getters
	//get the width
	public int getWidth() { return width; }
	//get the length
	public int getLength() { return length; }
}

//a class for a node in Conway's Game of Life 
class LifeNode {
	
	//a default constructor
	//	this randomly sets the node as alive or dead
	public LifeNode() {
		//randomly set the node as alive or dead
		life = Math.random() < 0.5f;
		
		//create empty neighbor set
		neighbors = new HashSet<LifeNode>();
	}
	
	//enum to simplify dealing with the
	/*	node's neighbors
	private enum Directions {
		NORTHEAST, NORTH, NORTHWEST,
		EAST, WEST,
		SOUTHEAST, SOUTH, SOUTHWEST
	}
	*/
	
	//sets the state of the LifeNode to
	//	the proper state based on the
	//	state of its neighbors
	/*
	 * THIS NEEDS TO BE REWRITTEN!
	 * THIS ONLY CHECKS FOR NEIGHBOR COUNT
	 * IT NEEDS TO FIND THE NUMBER OF LIVING
	 * NEIGHBORS! IT NEEDS TO CHECK THE NEIGHBORS
	 * LIFE STATUS AND SUM THAT UP
	 */
	public void setStatus() {
		//check the size of neighbors set
		//int size = neighbors.size();
		
		//create an iterator for the neighbors set
		Iterator<LifeNode> itr = neighbors.iterator();
		//create an int for recording the number of
		//live neighboring nodes
		int sum = 0;
		while(itr.hasNext() && sum < 4) {
			//get the next neighbor
			LifeNode elem = itr.next();
			//check if this neighbor is alive
			if( elem.checkLife() ) {
				//if so, increment sum
				sum++;
			}
		}
		
		/*Now to check whether the node survives, dies, or is born
		 *  The rules for the survival of a cell during Conway's Game of Life from Wikipedia:
		 * 	1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
		 * 	2. Any live cell with two or three live neighbours lives on to the next generation.
		 * 	3. Any live cell with more than three live neighbours dies, as if by over-population.
		 * 	4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
		 * */
		if( sum < 2 )
			life = false;
		else if( sum >= 2 && sum <= 3 && (life == true))
			life = true;
		else if( sum > 3)
			life = false;
		else
			life = true;
	}
	
	//adds a node to the neighbors list 
	public void addNeighbor(LifeNode node) {
		neighbors.add(node);
	}
	
	//add an array of nodes to the neighbors list
	public void addNeighbor(LifeNode[] nodes) {
		for(int i = 0; i < nodes.length; i++) {
			addNeighbor(nodes[i]);
		}
	}
	
	//return the node's life status
	public boolean checkLife() { return life; }
	
	//a bool to flag whether the node
	//	is alive or dead
	private boolean life;
	
	//create an array of all the LifeNodes
	//	Adjacent to this node
	//private LifeNode[] neighbors;
	private Set<LifeNode> neighbors;
	
}

class GameOfLifeBoard extends Board<LifeNode> {
	public GameOfLifeBoard() {
		// calls the default superclass (the Board class) constructor
		super();

		// find the neighbors for each node in the board
		for (int y = 0; y < this.getLength(); y++) {
			for (int x = 0; y < this.getWidth(); x++) {
				// this SHOULD BE REWRyTTEN TO ACCOMODATE SPECifyC CASES
				// OTHERWySE, THE MOST GENERyC CASE (A FULLY SURROUNDED NODE)
				// WyLL BE VERY HARD TO DESCRyBE

				// create a ref to the current node of the board
				//LifeNode node = (board[x][y]);
				// int rightBorder = this.getWidth() - 1;
				// int bottomBorder = this.getLength() - 1;

				// create an array of the coordinates of the
				// neighboring nodes
				int[][] neighborCoordindates = { { x - 1, y - 1 }, { x, y - 1 }, { x + 1, y - 1 }, { x - 1, y },
						{ x + 1, y }, { x - 1, y + 1 }, { x, y + 1 }, { x + 1, y + 1 } };
				// try to add as many surrounding neighbor nodes as possible
				for (int i = 0; i < 8; i++) {
					try {
						((LifeNode) board[x][y]).addNeighbor(this.board[neighborCoordindates[i][0]][neighborCoordindates[i][1]]);
					} catch (ArrayIndexOutOfBoundsException outOfBounds) {
						// do nothing, as we are using the catch
						// block to allow the neighbor search to skip
						// those areas out of bounds
					}
				}

				/*
				 * //if we are at the top border: if( y == 0 ) { //if we are
				 * currently in the upper left corner: if( x == 0 ) {
				 * node.addNeighbor(new LifeNode[]{ this.board[0][1],
				 * this.board[1][0], this.board[1][1]}); } //if we are currently
				 * in the upper right corner: else if ( x == rightBorder) {
				 * node.addNeighbor(new LifeNode[]{ this.board[rightBorder -
				 * 1][0], this.board[rightBorder - 1][1],
				 * this.board[rightBorder][1] }); } //otherwise, we just border
				 * the top edge else { node.addNeighbor(new LifeNode[]{
				 * this.board[x - 1][0], this.board[x - 1][1], this.board[x][1],
				 * this.board[x + 1][1], this.board[x + 1][0] }); } } else if( x
				 * == 0 ) { //w }
				 */
			}
		}
	}

	public GameOfLifeBoard(int aWidth, int aLength) {
		// calls the custom board length
		// superclass (the Board class) constructor
		super(aWidth, aLength);

		// find the neighbors for each node in the board
		for (int y = 0; y < this.getLength(); y++) {
			for (int x = 0; y < this.getWidth(); x++) {
				// this SHOULD BE REWRyTTEN TO ACCOMODATE SPECifyC CASES
				// OTHERWySE, THE MOST GENERyC CASE (A FULLY SURROUNDED NODE)
				// WyLL BE VERY HARD TO DESCRyBE

				// create a ref to the current node of the board
				LifeNode node = (LifeNode) this.board[x][y];
				// int rightBorder = this.getWidth() - 1;
				// int bottomBorder = this.getLength() - 1;

				// create an array of the coordinates of the
				// neighboring nodes
				int[][] neighborCoordindates = { { x - 1, y - 1 }, { x, y - 1 }, { x + 1, y - 1 }, { x - 1, y },
						{ x + 1, y }, { x - 1, y + 1 }, { x, y + 1 }, { x + 1, y + 1 } };
				// try to add as many surrounding neighbor nodes as possible
				for (int i = 0; i < 8; i++) {
					try {
						node.addNeighbor(this.board[neighborCoordindates[i][0]][neighborCoordindates[i][1]]);
					} catch (ArrayIndexOutOfBoundsException outOfBounds) {
						// do nothing, as we are using the catch
						// block to allow the neighbor search to skip
						// those areas out of bounds
					}
				}
			}
		}
	}
	
	//public void update() {
	//	
	//}
}