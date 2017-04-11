package com.peace.undirected.graph.interfaces;

public interface GraphInterface {

	public void addEdge(int v,int w);
	
	public Iterable<Integer> adj(int v);
}
