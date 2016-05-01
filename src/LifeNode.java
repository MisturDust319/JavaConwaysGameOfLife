import java.util.HashSet;
import java.util.Set;

public class LifeNode {

	//enum to simplify dealing with the
	//node's neighbors
	private enum Directions {
		NORTHEAST, NORTH, NORTHWEST,
		EAST, WEST,
		SOUTHEAST, SOUTH, SOUTHWEST
	}
	
	//sets the state of the LifeNode to
	//	the proper state based on the
	//	state of its neighbors
	private void setStatus() {
		
	}
	
	//a bool to flag whether the node
	//	is alive or dead
	private boolean life;
	
	//create an array of all the LifeNodes
	//	Adjacent to this node
	//private LifeNode[] neighbors;
	private Set<LifeNode> neighbors = new HashSet<LifeNode>();
	
}
