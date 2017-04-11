package com.peace.directed;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by girishkumarbanda on 25/03/2017 AD.
 */
public class DirectedCycle {
    private  boolean marked[];
    private  boolean onStack[];
    private  int [] edgeTo;
    private Stack<Integer> cycle;

    DirectedCycle(Digraph G,int s){
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int [G.V()];
        dfs(G,s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (int w: G.adj(v)){

            if (cycle !=null) return;
           else if(!marked[w]){
               marked[w] =true;
               edgeTo[w] =v;
               dfs(G,w);
           }
           else if(onStack[w]){
                cycle = new Stack<>();
                for (int x =v ; x!=w; x=edgeTo[x]){
                    cycle.push(x);
               }
               cycle.push(w);
               cycle.push(v);
           }
        }
        onStack[v] =false;
    }

    public  Iterable<Integer> cycle(){
        return  cycle;
    }

    public  boolean isCycle(){
        return cycle !=null;
    }

    public static  void main(String[] args){
        File file = new File("data/tinyDG.txt");
        try {
            Scanner scr = new Scanner(file);
            Digraph G = new Digraph(scr);
            System.out.println(G);
            int s = 0;
            DirectedCycle dc  = new DirectedCycle(G,s);
            if(dc.isCycle()){
                System.out.println(dc.cycle());
            }
            else{
                System.out.println("Directed Acyclic Graph");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
