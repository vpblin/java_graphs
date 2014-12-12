package Graph;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFS2 {
	 static class Node {

		  int value;
		  boolean visited = false; // optional
		  List vertices = new ArrayList<Integer>();

		  public Node(int value) {
		   super();
		   this.value = value;
		  }

		  public void addVertex(Node n) {
		   vertices.add(n);
		  }

		  @Override
		  public String toString() {
		   return "Node [value=" + value + ", visited=" + visited
		     + ", vertices=" + vertices + "]";
		  }
		 };

		 public static Node find(Node root, int element) {
		  // #1: Initialize queue (q)
		  Queue q = new ConcurrentLinkedQueue<>(); // some queue
		              // implementation
		  // #2: Push root node to queue
		  q.add(root);

		  // #3: While queue not empty
		  while (!q.isEmpty()) {

		   // #:4 Dequeue n
		   Node n = q.poll();
		   // visit this node
		   n.visited = true;

		   // #5: If n == required_node, return n;
		   if (n.value == element)
		    return n;

		   // #5: foreach vertices v of n
		   for (Node v : n.vertices) {
		    // #6: if v is visited, continue
		    if (v.visited)
		     continue;
		    // #7: else enque v
		    q.add(v);
		   }
		  }
		  // #8: return null;
		  return null; // cannot find element
		 }

}
