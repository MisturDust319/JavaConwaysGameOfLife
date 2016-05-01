package GameOfLife;

import java.util.HashSet;
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
	private void setStatus() {
		//check the size of neighbors set
		int size = neighbors.size();
		
		/* The rules for the survival of a cell during Conway's Game of Life
		 * From Wikipedia:
		 * 	1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
		 * 	2. Any live cell with two or three live neighbours lives on to the next generation.
		 * 	3. Any live cell with more than three live neighbours dies, as if by over-population.
		 * 	4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
		 * */
		if( size < 2 )
			life = false;
		else if( size >= 2 && size <= 3 && (life == true))
			life = true;
		else if( size > 3)
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
	
	//a bool to flag whether the node
	//	is alive or dead
	private boolean life;
	
	//create an array of all the LifeNodes
	//	Adjacent to this node
	//private LifeNode[] neighbors;
	private Set<LifeNode> neighbors;
	
}
