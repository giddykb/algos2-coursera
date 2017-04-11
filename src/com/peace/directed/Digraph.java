package com.peace.directed;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Digraph {

	private int V;
	private int E;
	private ArrayList [] adj;
	private int[] indegree;

	public Digraph(int V) {
		// TODO Auto-generated constructor stub
		this.V=V;
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		indegree = new int[V];

		for (int v=0;v<V;v++){
		    adj[v] = new ArrayList<Integer>();
        }
	}
	
	public Digraph(Scanner scr) {
		// TODO Auto-generated constructor stub
		this(scr.nextInt());
		this.E = scr.nextInt();
		for (int i=0;i<E;i++)
        {
            int v = scr.nextInt();
            int w =scr.nextInt();
            addEdge(v,w);
        }
	}

	public void addEdge(int v,int w){
		validateVertex(v);
		validateVertex(w);
        adj(v).add(w);
        indegree[w]++;

    }

    public ArrayList<Integer> adj(int v){

	    return adj[v];
    }


    private void  validateVertex(int v){
    	if(v<0 ) throw new IllegalArgumentException("vertex  should be non negative ");
    }
    
    public int V(){
    	return V;
    }
    
    public int E(){
    	return E;
    }


    public Digraph reverse(){
        Digraph reverse = new Digraph(V);
        for (int v=0;v<V;v++){
            for (int w :adj(v)) {
                reverse.addEdge(w,v);
            }
        }
        return reverse;
    }

    public int inDegree(int v){
        return indegree[v];
    }

    public int outDegree(int v){
        return adj(v).size();
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        for (int v=0; v<V; v++){
            sb.append(v + " :");
            for (int w: adj(v)){
                sb.append(w +" ");
            }
            sb.append("\n");
        }

        return  sb.toString();
    }

    public static void main(String [] args){
        File file = new File("data/tinyDG.txt");
        try {
            Scanner scr = new Scanner(file);
            Digraph G = new Digraph(scr);
            System.out.println(G);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
