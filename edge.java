package Graph;

public class edge {
	private int a;
	boolean visited = false;
	
	public edge(int a, boolean visited){
		this.a = a;
		this.visited = visited;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
}
