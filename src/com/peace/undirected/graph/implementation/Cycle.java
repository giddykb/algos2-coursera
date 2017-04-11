package com.peace.undirected.graph.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Cycle {

	private boolean marked[];
	private int edgeTo[];
	Stack<Integer> cycle ;

	public Cycle(Graph G) {
		// TODO Auto-generated constructor stub

		if(hasSelfLoop(G)) return;

		marked   = new boolean [G.getV()];
		edgeTo = new int [G.getV()];
		for (int v = 0; v < G.getV(); v++) {
			if(!marked[v]){
				dfs(G,v,-1);
			}
		}

	}


	private boolean hasSelfLoop(Graph G){

		marked   = new boolean [G.getV()];

		for (int v = 0; v < marked.length; v++) {
			for( int w :G.adj(v)){
				if(v==w){
					cycle = new Stack<>();
					cycle.push(v);
					cycle.push(v);
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasCycle(){
		return cycle != null;
	}

	private void dfs(Graph g, int v, int parent) {
		// TODO Auto-generated method stub
		marked[v] =true;

		for(int w :g.adj(v)){

			if( cycle != null) return ;

			if(!marked[w]){
				edgeTo[w] =v;
				dfs(g,w,v);
			}
			else if(w != parent){
				cycle  = new Stack<>();
				for(int x = v; x !=w ; x = edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
				System.out.println("Cycle detected");
			}
		}
	}

	public Iterable<Integer> cycle(){
		return cycle;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("data/tinyG.txt");
		try {
			Scanner scr = new Scanner(file);
			Graph G = new Graph(scr);

			Cycle finder = new Cycle(G);

			if(finder.hasCycle()){
				System.out.println(finder.cycle());
			}
			else{
				System.out.println("Graph is acyclic");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
