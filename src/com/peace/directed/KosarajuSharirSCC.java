package com.peace.directed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by girishkumarbanda on 29/03/2017 AD.
 * Strongly Connected Components
 * @noinspection ALL
 */
public class KosarajuSharirSCC {
    private  boolean marked [];
    private   int cc[];
    private int count ;
    KosarajuSharirSCC(Digraph G)
    {
        marked = new boolean[G.V()];
        cc  = new int [G.V()];
        DepthFirstOrder dfo = new DepthFirstOrder(G);

        Digraph reverse = G.reverse();
        for (int v: dfo.reversePostOrder()){
                if(!marked[v]) {
                    dfs(reverse, v);
                    count++;
                }
        }
    }

    private  void dfs(Digraph G, int v){
            marked[v] =true;
            cc[v]=count;

            for (int w : G.adj(v)){
                if (!marked[w]){
                    dfs(G,w);
                }
            }
    }

    private  boolean isConnected(int v ,int w){
            return  cc[w] ==cc[v];
    }

    public int [] connectedComponent(){
        return  cc;
    }

    public int count(){
        return  count;
    }

    public  static  void main(String [] args){

        File file = new File("data/mediumDG.txt");
        try {
            Scanner scr = new Scanner(file);
            Digraph G = new Digraph(scr);
            KosarajuSharirSCC   scc =  new KosarajuSharirSCC(G);

            int count =scc.count();
            System.out.println(count + " strong components ");

            int [] cc = scc.connectedComponent();

            List<Integer> components []=  new ArrayList [count];

            for (int i =0;i<count;i++){
                components [i] = new ArrayList<>();
            }
            for (int v=0;v<G.V();v++){
                components[cc[v]].add(v);
            }

            for (int i =0;i<count;i++){
                System.out.println(components[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
