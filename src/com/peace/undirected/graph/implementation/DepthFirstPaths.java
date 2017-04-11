package com.peace.undirected.graph.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstPaths {

	private boolean marked[];
	private int edgeTo[];
	private final int s;
	
	public DepthFirstPaths(Graph G,int s){
		this.s=s;
		marked  = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		dfs(G,s);
	}
	
	private void dfs(Graph g, int v) {
		// TODO Auto-generated method stub
		marked[v]=true;
		for (int w : g.adj(v)) {
			if(!marked[w]){
				edgeTo[w]=v;
				dfs(g,w);
			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	
	public Iterable<Integer> pathTo(int v){
		
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<>();
		for(int x = v; x != s; x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("data/tinyG.txt");
		try {
			Scanner scr = new Scanner(file);
			Graph G = new Graph(scr);
			int s = 10;
			
			DepthFirstPaths dfp = new DepthFirstPaths(G, s);
			
			for (int v = 0; v < G.getV(); v++) {

				if(dfp.hasPathTo(v)){
					System.out.format("%d to %d ", s,v);
					for(int w : dfp.pathTo(v)){
						if(w==s) System.out.print(""+w);
						else System.out.print(w+"-");
					}
				}
				else
					System.out.format("%d to %d are not connected", s,v);
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
