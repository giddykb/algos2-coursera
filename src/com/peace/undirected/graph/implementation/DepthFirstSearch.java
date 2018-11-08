package com.peace.undirected.graph.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** @noinspection ALL */ /*
 * This class represents the data type for determining the vertices connected to 
 * source and address whether the given input graph is connected or not 
 * */
public class DepthFirstSearch {

	private boolean marked [];
	private int edgeTo[];
	
	private int count ; // no of vertices connected to the source
	
	private int source;
	
	public DepthFirstSearch(Graph G) {
		// TODO Auto-generated constructor stub
		marked = new boolean[G.getV()];
		edgeTo = new int [G.getV()];
		this.count=0;
		for (int i = 0; i < G.getV(); i++) {
			dfs(G,i);
		}
	}
	
	public DepthFirstSearch(Graph G,int s) {
		// TODO Auto-generated constructor stub
		this.source=s;
		this.count=0;
		marked = new boolean[G.getV()];
		edgeTo = new int [G.getV()];
		dfs(G,source);
		
	}

	
	private void dfs(Graph g , int v){

		count++;
		marked[v] = true;
		for(int w :g.adj(v)){
			if(!marked[w]){
				edgeTo[w] =v;
				dfs(g,w);
			}
		}
	}
	
	public boolean marked(int v){
		return marked[v];
	}
	
	public int count(){
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("data/tinyG.txt");
		try {
			Scanner scr = new Scanner(file);
			Graph G = new Graph(scr);
			int s = 9;
			DepthFirstSearch search = new DepthFirstSearch(G, s);
			
			for(int v=0;v<G.getV();v++){
				if(search.marked(v))
					System.out.print(v +" " );
			}
			
			if(search.count() != G.getV())
				System.out.println("NOT CONNECTED");
			else
				System.out.println("CONNECTED");
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
