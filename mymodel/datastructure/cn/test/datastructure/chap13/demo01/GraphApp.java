package cn.test.datastructure.chap13.demo01;

public class GraphApp {
	
	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		
		System.out.println("visits :");
		graph.dfs();
		System.out.println();
		
	}
}
