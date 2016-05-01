package GameOfLife;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//a class for a node in Conway's Game of Life 
public class LifeNode {
	
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
