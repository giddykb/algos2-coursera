package com.peace.undirected.graph.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.peace.undirected.graph.interfaces.GraphInterface;

/** @noinspection ALL */
public class Graph implements GraphInterface {

	private int V;
	private int E;

	private List<Integer> [] adjacencyList;
	
	public Graph(int V){
		
		if(V<0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.V = V;
		adjacencyList  = (List<Integer> []) new List [V];

		for(int v=0;v<V;v++){
			adjacencyList[v] = new ArrayList<Integer>();
		}

	}
	
	public Graph(Scanner scr){
	
		this(scr.nextInt());

		try{
		
			this.E = scr.nextInt();
			if(E<0) throw new IllegalArgumentException("Number of edges must be nonnegative");

			while(scr.hasNextInt()){
				int v = scr.nextInt();
				int w = scr.nextInt();
				addEdge(v,w);
			}
		}
		catch(NoSuchElementException e){
			throw new IllegalArgumentException("Invaid input format in graph construnction ",e);
		}
	}
	@Override
	public void addEdge(int v, int w) {
		// TODO Auto-generated method stub
		adjacencyList[v].add(w);
		adjacencyList[w].add(v);
	}


	@Override
	public Iterable<Integer> adj(int v) {
		// TODO Auto-generated method stub
		return adjacencyList[v];
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		
		for(int v =0 ;v<V;v++){
			str.append(v + " : ");
	
			for(int w :adjacencyList[v]){
				 str.append(w +" ");
			}
			
			str.append("\n");
				
		}
		
		return str.toString();
	}

	
	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	
	public static void main(String [] args){
		File file = new File("data/tinyG.txt");
		try {
			Scanner scr = new Scanner(file);
			Graph G = new Graph(scr);
			System.out.println(G);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
