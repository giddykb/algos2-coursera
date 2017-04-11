package com.peace.directed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by girishkumarbanda on 28/03/2017 AD.
 */
public class Topological {
    private  boolean marked[];
    private  int s;
    Stack<Integer> postOrder ;

    Topological(Digraph G,int s){
        marked = new boolean[G.V()];
        this.s =s;
        postOrder = new Stack<Integer>();

        for (int v=0;v<G.V();v++){
            if (!marked(v)){
                dfs(G,v);
            }
        }

    }

    private  void dfs(Digraph G, int v){
        marked[v] =true;
        for (int w: G.adj(v)){
            if (!marked(w)) dfs(G,w);
        }
        postOrder.push(v);
    }
    public  boolean marked(int v){
        return  marked[v];
    }

    public  Iterable<Integer> reversePostOrder(){
        return  postOrder;
    }
    public static void  main(String [] args){
        String fileName ="data/jobs.txt";
        String delimete ="/";
        try{
            SymbolDiGraph sg = new SymbolDiGraph(fileName,delimete);
            Digraph G = sg.diGraph();
            System.out.println(G);

            for (int v=0;v<G.V();v++){
                System.out.println(sg.name(v) +"   "+v);
            }
            System.out.println("-------");

            for (int v=0;v<G.V();v++){
                if (G.adj(v).size()>0) {
                    System.out.println(sg.name(v));

                    for (int w : G.adj(v)) {
                        System.out.print(" " + sg.name(w));
                    }
                    System.out.println("");
                }
            }

            DepthFirstOrder dfo = new DepthFirstOrder(G);

            System.out.println("------Topological Sort-----");
            for (int v : dfo.reversePostOrder()){
                System.out.println(sg.name(v));
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
