package com.peace.directed;

import com.peace.undirected.graph.implementation.Graph;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by girishkumarbanda on 23/03/2017 AD.
 */
public class DirectedDFS {
    private  boolean marked[];
    private int edgeTo[];
    private int disTo[];

    public  DirectedDFS(Digraph G){
        int V = G.V();
        int E = G.E();

        edgeTo = new int[V];
        marked = new boolean[V];
        disTo  = new int[V];
        Arrays.fill(disTo,Integer.MIN_VALUE);

        for (int v=0;v<V;v++){
            if(!marked[v]){
                disTo[v] = 0;
                dfs(G,v);
            }
        }
    }

    public DirectedDFS(Digraph G,int s)
    {
        int V = G.V();
        int E = G.E();

        edgeTo = new int[V];
        marked = new boolean[V];
        disTo  = new int[V];
        disTo[s]=0;
        dfs(G,s);

    }


    public  DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (int s:sources){
            if (!marked(s)) dfs(G,s);
        }

    }

    private  void dfs(Digraph G, int v){
        marked[v]=true;
        for ( int w :G.adj(v)){
            if (!marked(w)) {
                edgeTo[w]=v;
                disTo[w]=disTo[v]+1;
                dfs(G,w);
            }
        }
    }

    public  boolean marked(int v){
        return marked[v];
    }

    public  int disTo(int v){
        return disTo[v];
    }


}
