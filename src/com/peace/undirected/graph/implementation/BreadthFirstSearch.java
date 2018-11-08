package com.peace.undirected.graph.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/** @noinspection ALL */
public class BreadthFirstSearch {

	private boolean marked[] ;
	private int edgeTo[];
	private int distTo[];
	
	BreadthFirstSearch(Graph G , int s){
	
		marked = new boolean [G.getV()];
		edgeTo   =  new int [G.getV()];
		distTo = new int [G.getV()];
		Arrays.fill(distTo,Integer.MAX_VALUE);
		bfs(G,s);
	}
	
	private void bfs(Graph g, int s) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		marked[s]=true;
		distTo[s]=0;
		
		while(!queue.isEmpty()){
			int top = queue.poll();
			
			for(int w : g.adj(top)){
				if(!marked[w]){
					queue.add(w);
					marked[w]=true;
					edgeTo[w] =top;
					distTo[w]=distTo[top]+1;
				}
			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		Stack<Integer> path = new Stack<>();
		int x;
		for( x=v; distTo[x]!=0;x=edgeTo[x]){
			path.push(x);
		}
		
		path.push(x);
		return path;
	}
	
	public int distTo(int v){
		return distTo[v];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("data/tinyCG.txt");
		try {
			Scanner scr = new Scanner(file);
			Graph G = new Graph(scr);
			System.out.println(G);
			int s = 0;
			
			BreadthFirstSearch bfs = new BreadthFirstSearch(G, s);
			
			for(int v=0;v<G.getV();v++){
				if(bfs.hasPathTo(v)){
					System.out.format("%d to %d  (%d) ",s,v,bfs.distTo(v));
					
					for(int w : bfs.pathTo(v)){
						if(w==s)System.out.print(""+w);
						else System.out.print(w+"-");
						
					}
					System.out.println("\n");
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
