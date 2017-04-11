package com.peace.mst;

/**
 * Created by girishkumarbanda on 29/03/2017 AD.
 */
public class Edge  implements  Comparable<Edge>{
    private  int v ;
    private  int w ;
    double weight;

    Edge(int v ,int w ,double weight){
        this.v= v;
        this.w= w;
        this.weight = weight;

    }

    public  int other(int vertex){
        if(vertex == v ) return  w;
        else return  v ;
    }
    public int either(){
        return  v;
    }

    public  double weight(){
        return weight;
    }

    public  int compareTo(Edge that){
        if (this.weight <that.weight ) return  -1;
        else if(this.weight > that.weight ) return  1;
        else return  0;
    }

    public  String toString(){
        return  "(" +this.v +"," +this.w+","+this.weight+")";
    }

}
