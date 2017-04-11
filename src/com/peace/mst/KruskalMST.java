package com.peace.mst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by girishkumarbanda on 30/03/2017 AD.
 */
public class KruskalMST {

    Queue<Edge> mst = new ArrayDeque<>();

    KruskalMST(EdgeWeightedGraph G){

        PriorityQueue<Edge>  pq = new PriorityQueue<>(G.V(), new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return  o1.compareTo(o2);
            }
        });

        for ( Edge e : G.edges()){
            pq.add(e);
        }

        UF  uf = new UF(G.V());

        while (!pq.isEmpty() &&  mst.size() < G.V()-1 ){
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);

            if(!uf.connected(v,w)){
                uf.union(v,w);
                mst.add(e);
            }
        }
    }

    public Iterable<Edge> edges(){
        return  mst;
    }

    public  static  void main(String [] args){
        File file = new File("data/tinyEWG.txt");
        try {
            Scanner scr = new Scanner(file);
            EdgeWeightedGraph  G =  new EdgeWeightedGraph(scr);
            KruskalMST  mst = new KruskalMST(G);

            double minWeight =0;
            for (Edge e: mst.edges()){
                    minWeight+=e.weight();
                System.out.println(e);
            }

            System.out.println("Weight of minimum spanning tree : " + minWeight);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
