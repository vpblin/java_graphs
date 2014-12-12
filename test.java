package Graph;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Graph2.Edge;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		
		Graph g = new Graph("input2.txt");
		
		System.out.println(g.getV());

		g.String();
		
		
		DFS search2 = new DFS(g);
		
		System.out.println("Are 9 and 0 adjacent? " + g.isAdjacent(0, 9));
		System.out.println("Are 4 and 7 adjacent? " + g.isAdjacent(4, 7));

		
		search2.DFScomplicated(4);
		System.out.println("Are 9 and 0 connected? " + search2.connected(0, 9));
		System.out.println("Are 4 and 7 connected? " + search2.connected(4, 7));

		
		
		int [] path = search2.getEdgeTo();
		for(int i = 0; i < path.length; i++){
			System.out.println(i + "    " + path[i]);
		}

		int searching = 9;
		System.out.println("DFS path from 9 to 4: ");
		search2.setEverythingFalse();
		
		/*
		if(search2.connected(9, 0)){
			
			
		while(searching != 0){
			searching = path[searching];
			System.out.print(searching +  "   ");
		}
		}else{
			System.out.println("No Path Found");
		}
		System.out.println("\n\nPrint Connected Components ...");
*/
		search2.printConnectedComponents();
		
		
		System.out.println("\n\nSearching BFS ...");
		BFS bf = new BFS(g, 5);
		int[] pathBFS = bf.getEdgeTo();
		for(int i = 0; i < pathBFS.length; i++){
			System.out.println(i + "    " + pathBFS[i]);
		}
		int searching2 = 9;
		
		System.out.println("BFS path from 9 to 4: ");
		/*
		if(search2.connected(9, 4)){
		
		while(searching2 != 4){
			searching2 = pathBFS[searching2];
			System.out.print(searching2 +  "   ");
		}
		}
		else{
			System.out.println("No Path Found");
		}
		*/
		boolean [] visited = bf.getVisited();
		bf.printVisited();
	}

}
