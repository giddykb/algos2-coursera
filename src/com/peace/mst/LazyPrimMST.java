package com.peace.mst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by girishkumarbanda on 30/03/2017 AD.
 * @noinspection ALL
 */
public class LazyPrimMST {

    Queue<Edge> mst ;
    private  boolean marked[];
    PriorityQueue<Edge>  pq ;


    LazyPrimMST(EdgeWeightedGraph G){
        marked = new boolean[G.V()];
        mst = new ArrayDeque<>();
       /* pq =  new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.compareTo(o2);
            }
        })*/;

        visit(G,0);

        while (!pq.isEmpty()){
            Edge e = pq.remove();

            int p = e.either();
            int q = e.other(p);

            if(marked[p] && marked[q]) continue;
            mst.add(e);
            if(!marked[p]) visit(G,p);
            if (!marked[q]) visit(G,q);

         }

    }

    private  void visit(EdgeWeightedGraph G,int v){
        marked[v] = true;
        for (Edge e : G.adj(v)){
            int q = e.other(v);
            if(!marked[q]) pq.add(e);

        }
    }

    public  Iterable<Edge> edges(){
        return  mst;
    }


    public  static  void main(String [] args){
        File file = new File("data/tinyEWG.txt");
        try {
            Scanner scr = new Scanner(file);
            EdgeWeightedGraph  G =  new EdgeWeightedGraph(scr);
            System.out.println(G);

            LazyPrimMST  prims = new LazyPrimMST(G);

            double minWeight =0;
            for (Edge e: prims.edges()){
                minWeight+=e.weight();
                System.out.println(e);
            }

            System.out.println("Weight of minimum spanning tree : " + minWeight);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
