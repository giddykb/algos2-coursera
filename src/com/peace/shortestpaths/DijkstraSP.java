package com.peace.shortestpaths;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by girishkumarbanda on 30/03/2017 AD.
 * @noinspection ALL
 */
public class DijkstraSP {

    private int [] edgeTo;
    private  double  disTo[];
    PriorityQueue<Double> pq ;

    DijkstraSP(EdgeWeightedDiGraph G,int s){

        edgeTo = new int [G.V()];
        disTo = new double[G.V()];
        pq  = new PriorityQueue<>(G.V());

        Arrays.fill(disTo,Integer.MAX_VALUE);
        disTo[s] = 0.0;


        while (!pq.isEmpty()){

        }

    }


    private  void relax(DirectedEdge e){
            int v = e.from();
            int w = e.to();

            double oldDist = disTo[w];

            if(disTo[w] > disTo[v] +e.weight()){
                disTo[w] = disTo[v] +e.weight();
                edgeTo[w] =v;

                // if(pq.contains(disTo[w])) pq.


            }
    }



}
