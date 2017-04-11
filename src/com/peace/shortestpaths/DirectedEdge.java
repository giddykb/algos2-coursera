package com.peace.shortestpaths;

import com.peace.directed.DirectedCycle;

/**
 * Created by girishkumarbanda on 30/03/2017 AD.
 */
public class DirectedEdge {

    private  int v,w;
    private  double weight;

    DirectedEdge(int v ,int w , double weight){
        this.v=v;
        this.w=w;
        this.weight = weight;
    }

    public  int from(){
        return  v;
    }

    public  int to(){
        return  w;
    }

    public  double weight(){
        return  weight;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
