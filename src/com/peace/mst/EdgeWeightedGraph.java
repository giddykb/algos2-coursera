package com.peace.mst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by girishkumarbanda on 29/03/2017 AD.
 */
public class EdgeWeightedGraph {

    private  int V;
    private  int E;
    ArrayList<Edge> adj  [];

    EdgeWeightedGraph(int V){
        this.V =V;
        adj = (ArrayList<Edge>[]) new ArrayList[V];

        for (int v =0;v<V;v++){
            adj[v] = new ArrayList<Edge>();
        }


    }

    EdgeWeightedGraph(Scanner scr){
        this(scr.nextInt());
        this.E = scr.nextInt();

        while (scr.hasNextLine()){
            int v = scr.nextInt();
            int w = scr.nextInt();
            double weight = scr.nextDouble();
            addEdge(new Edge(v,w,weight));

        }
    }

    private  void addEdge(Edge edge){
        int v = edge.either();
        int w =  edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
    }

    public  Iterable<Edge> adj(int v){
        return  adj[v];
    }


    public  Iterable<Edge> edges(){
        ArrayList<Edge> list = new ArrayList<>();
        for (int v =0;v<V;v++){
            int selfLoops =0;
            for (Edge e : adj(v)){
                int w = e.other(v);
                if(v< w) list.add(e);
                else if( v == e.other(v)){
                    if (selfLoops%2 ==0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return  list;

    }


    public   int V(){
        return  V;
    }

    public  int E(){
        return  E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V: "+V +", E: "+E +"\n" );
        for (int vertex =0;vertex<V;vertex++){
            sb.append(vertex+ ": ");
            for (Edge e : adj(vertex)){
                int v = e.either();
                int w =e.other(v);
                double weight = e.weight();
                sb.append( v +"-"+w + " "+weight +"  ") ;
            }
            sb.append("\n");
        }

        return  sb.toString();
    }


    public  static  void main(String [] args){
        File file = new File("data/tinyEWG.txt");
        try {
            Scanner scr = new Scanner(file);
            EdgeWeightedGraph ewg = new EdgeWeightedGraph(scr);
            System.out.println(ewg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
