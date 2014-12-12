package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class DFS {
	private Graph G;
	private boolean[] visited;
	private int[] edgeTo;
	private int pathInt;
	private int[] path;
	private int[] parent;
	Collection<Set<Integer>> col;

	// private Stack<Integer> path;
	public DFS(Graph G) {
		pathInt = 0;
		this.G = G;
		visited = new boolean[G.getV()];
		parent = new int[G.getV()];
		path = new int[G.getV()];

		setEdges();
		edgeTo = new int[G.getV()];
	}

	public void setEverythingFalse() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

	}

	public void resetParent() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
	}

	public void setEdges() {

	}

	public LinkedList<Integer> DFSPath(int v, int des) throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (v == des) {
			return list;
		}

		list.add(v);

		visited[v] = true;

		for (int a : G.getAdjacent(v)) {

			if (visited[a] == false) {
				visited[a] = true;
				list.add(a);
				DFSPath(a, des);
				// path.add(a);
			}
		}

		return list;

	}

	public boolean hasUnvisited() {
		boolean vis = true;
		for (boolean bol : visited) {
			if (bol = false)
				vis = false;
		}
		return vis;

	}

	public int getNextUnvisited() {
		int vis = 0;
		for (int k = 0; k < visited.length; k++) {
			if (visited[k] = false)
				return k;
		}
		return -1;

	}

	public LinkedList<Integer> DFSGetList(int v) {
		visited[v] = true;
		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int a : G.getAdjacent(v)) {
			if (!visited[a]) {
				visited[a] = true;
				list.add(a);
				DFSGetList(a);
				// path.add(a);
			}
		}

		return list;
	}

	public void DFScomplicated(int v) {

		for (int a : G.getAdjacent(v)) {
			{
				if (this.visited[a] == false) {
					edgeTo[a] = v;
					this.visited[a] = true;
					DFScomplicated(a);
				}
			}
		}
	}

	public int[] getEdgeTo() {
		return edgeTo;
	}

	public void DFS(int v) {
		visited[v] = true;

		for (int a : G.getAdjacent(v)) {
			if (!visited[a]) {
				visited[a] = true;
				parent[a] = v;
				DFS(a);
				// path.add(a);
			}
		}
	}

	/*
	 * public Object[] getPath(){ Object[] path_final = path.toArray(); return
	 * path_final; }
	 */

	public boolean[] getVisited() {
		return visited;
	}

	public boolean connected(int a, int b) {
		DFS(a);

		return (visited[a] && visited[b]);
	}

	public ArrayList<LinkedList<Integer>> getConnectedComponents() {
		setEverythingFalse();
		ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
		while (getNextUnvisited() > -1) {
			LinkedList<Integer> set = DFSGetList(getNextUnvisited());
			list.add(set);
		}

		return list;

	}

	public void printConnectedComponents() {
		LinkedList<Integer>[] list = new LinkedList[G.getV()];
		for (int i = 0; i < G.getV(); i++) {
			list[i] = new LinkedList();

		}

		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				list[0].add(i);
		}
		int not = 0;
		int counter = 1;
		boolean[] visited2 = new boolean[visited.length];
		for (int i = 0; i < visited2.length; i++) {
			visited2[i] = false;
		}

		while ((not = getNextUnvisited()) > -1) {
			DFS(not);
			if (visited2[not] == false && visited[not] == true) {
				list[counter].add(not);
			}

		}
		visited2 = visited;
		counter++;

		for (int i = 0; i < list.length; i++) {
			if (!list[i].isEmpty()) {
				System.out.println();

				System.out.println(i + "    ");
			}
			for (int j = 0; j < list[i].size(); j++) {
				System.out.print("  " + list[i].get(j));
			}
		}
	}

}
