package com.peace.mst;

/**
 * Created by girishkumarbanda on 29/03/2017 AD.
 */
public class UF {
    private  int [] parent ;
    private  byte [] rank;
    private  int count ;


    UF(int v){
        parent = new int [v];
        rank  = new byte [v];
        count =v;
        for (int i=0;i<v;i++){
            parent[i]=i;
        }
    }

    public int find(int p){
        while( p!= parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return  p;
    }

    public void union(int p ,int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ ) return;
        if(rank[rootP] < rank[rootQ]) parent[p] =rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[q] = rootP;
        else{
             parent[rootQ] =rootP;
             rank[rootP]++;
        }
        count--;

    }

    public  boolean connected(int p ,int q){
        return  find(p) == find(q);
    }

    public  int count(){
        return  count;
    }




}
