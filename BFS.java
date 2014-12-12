package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import Graph.AdjacencyList.Node;
import Graph.AdjacencyList.NodeColour;

public class BFS {
	public boolean[] visited;
	public Queue<Integer> que;
	private int[] edgeTo;


	public BFS(Graph s) {
		visited = new boolean[s.getV()];
		edgeTo = new int[s.getV()];
		for(int i = 0; i < visited.length; i++){
			visited[i] = false;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		LinkedList list = s.getAdjacent(0);
		que.add(4);
		visited[4] = true;

		
		while (!que.isEmpty()) {
			int i = que.poll();

				list = s.getAdjacent(i);
				visited[i] = true;

				while (hasUnvisited(list)) {
					int next = getNextUnvisited(visited, list);
					visited[next] = true;
					edgeTo[next] = i;
					que.add(next);
				}

			
		}

	}
	
	public BFS(Graph s, int root) {
		visited = new boolean[s.getV()];
		edgeTo = new int[s.getV()];
		for(int i = 0; i < visited.length; i++){
			visited[i] = false;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		LinkedList list = s.getAdjacent(0);
		que.add(root);
		visited[root] = true;

		
		while (!que.isEmpty()) {
			int i = que.poll();

				list = s.getAdjacent(i);
				visited[i] = true;

				while (hasUnvisited(list)) {
					int next = getNextUnvisited(visited, list);
					visited[next] = true;
					edgeTo[next] = i;
					que.add(next);
				}

			
		}

	}

	public void printVisited(){
		System.out.println("VISITED :");
		for(int m = 0; m < visited.length; m++){
			System.out.print(visited[m] + " ");
		}

	}
	
	public void setVisitedFalse(){
		for(int i = 0; i < visited.length; i++){
			System.out.println(i);
			visited[i] = false;
		}
	}
	public boolean[] getVisited(){
		return this.visited;
	}
	public int getNextUnvisited(boolean[] visited, LinkedList<Integer> list) {
		for (int a : list) {
			if (visited[a] == false) {
				return a;
			}
		}
		return -1;

	}
	public int[] getEdgeTo() {
		return edgeTo;
	}

	public boolean hasUnvisited(LinkedList<Integer> list) {

		for (int a : list) {
			if (visited[a] == false) {
				return true;
			}
		}
		return false;
	}

}
