package com.peace.shortestpaths;

import com.peace.mst.Edge;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by girishkumarbanda on 30/03/2017 AD.
 * @noinspection ALL
 */
public class EdgeWeightedDiGraph {

    private  int V;
    private  int E;

    ArrayList [] adj;

    EdgeWeightedDiGraph(int V){
        this.V =V;
        adj  = new ArrayList[V];

        for (int v = 0; v <V ; v++) {
            adj[v] = new ArrayList<DirectedEdge>();
        }

    }

    EdgeWeightedDiGraph(Scanner scr){
        this(scr.nextInt());
        this.E =scr.nextInt();
        while (scr.hasNextLine()){
            int v =scr.nextInt();
            int w = scr.nextInt();
            double weight  =scr.nextDouble();
            addEdge(new DirectedEdge(v,w,weight));
        }
    }

    private void addEdge(DirectedEdge directedEdge) {
        int v = directedEdge.from();
        adj[v].add(directedEdge);

    }

    public  Iterable<DirectedEdge> adj(int v){
        return  adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        ArrayList<DirectedEdge>  list = new ArrayList<>();

        for (int v = 0; v <V ; v++) {
            for (DirectedEdge e: adj(v)){
                list.add(e);
            }
        }

        return  list;
    }


    public int V(){
        return  V;
    }

    public  int E(){
        return  E;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < V ; v++) {
            sb.append(v +": ");
            for ( DirectedEdge e:
                 adj(v)) {
                sb.append(e +" ");
            }
            sb.append("\n");

        }
        return  sb.toString();
    }




}
