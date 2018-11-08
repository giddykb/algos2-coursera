package com.peace.directed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by girishkumarbanda on 24/03/2017 AD.
 * @noinspection ALL
 */
public class BreadthFirstDirectedPaths {
    private boolean marked[];
    private  int edgeTo[];
    private  int s ;

    BreadthFirstDirectedPaths(Digraph G, int s ){
        marked = new boolean[G.V()];
        edgeTo = new int [G.V()];
        this.s =s;
        bfs(G,s);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        while (!queue.isEmpty()){
            Integer  v = queue.remove();
            marked[v]=true;
            for (int w : G.adj(v)){
                if(!marked[w]){
                    queue.add(w);
                    edgeTo[w]=v;
                }
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

    public  static void main(String [] args){
        File file = new File("data/tinyDG.txt");
        try {
            Scanner scr = new Scanner(file);
            Digraph G = new Digraph(scr);
            System.out.println(G);
            int s=3;

            BreadthFirstDirectedPaths  bfd = new BreadthFirstDirectedPaths(G,s);

            for (int v = 0;v<G.V();v++){
                if(bfd.hasPath(v)){
                    System.out.format("%d to %d --> ",s,v);
                    for (int w: bfd.pathTo(v)){
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
