package com.peace.directed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by girishkumarbanda on 23/03/2017 AD.
 * @noinspection ALL
 */
public class DepthFirstDirectedPaths {
    private  boolean marked[];
    private  int edgeTo[];
    private  int s ;

    DepthFirstDirectedPaths(Digraph G, int s){
        this.s=s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G,s);
    }

    private  void  dfs(Digraph G,int v){
        marked[v] =true;
        for (int w:G.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }
        }
    }

    public  boolean hasPath(int v){
        return  marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        Stack<Integer> path = new Stack<>();
        if(!hasPath(v)) return  null;
        for (int x =v; x!=s ; x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return  path;
    }


    public static void main(String[] args){
        File file = new File("data/tinyDG.txt");
        try {
            Scanner scr = new Scanner(file);
            Digraph G = new Digraph(scr);
            System.out.println(G);
            int s=3;

            DepthFirstDirectedPaths  ddp = new DepthFirstDirectedPaths(G,s);

            for (int v = 0;v<G.V();v++){
                if(ddp.hasPath(v)){
                    System.out.format("%d to %d --> ",s,v);
                    for (int w: ddp.pathTo(v)){
                        if(w==s)System.out.print(""+w);
                        else System.out.print( w+"-");
                    }
                }
                else{
                    System.out.format("%d to %d  not connected",s,v);
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
