package com.peace.undirected.graph.implementation;

import java.util.Stack;

public class Bipartite {

	private boolean isBipartitie;
	private boolean marked[];
	private boolean color[];
	private int edgeTo[];
	Stack<Integer> cycle ;
	
	public Bipartite(Graph G) {
		// TODO Auto-generated constructor stub
		isBipartitie = true;
		marked = new boolean[G.getV()];
		color = new boolean[G.getV()];
		edgeTo = new int [G.getV()];
		 
		for (int v = 0; v < G.getV(); v++) {
			if(!marked[v]) dfs(G,v);
		}
	}
	
	private void dfs(Graph g, int v){
		marked[v] =true ;
		
		for(int w : g.adj(v)){
			if(!marked[w]){
				color[w] =!color[v];
				edgeTo[w] = v;
				dfs(g,w);
			}
			else if(color[w] == color[v]){
				isBipartitie  = false;
				cycle = new Stack<>();
				
				for (int x = v; x !=w; x=edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
			}
		}
	}
	
	public boolean isBipartite(){
		return isBipartitie;
	}
	
	public Iterable<Integer> oddCycle(){
		return cycle;
	} 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
