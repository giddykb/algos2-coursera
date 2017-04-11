package com.peace.directed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by girishkumarbanda on 28/03/2017 AD.
 */
public class DepthFirstOrder {

    private  boolean marked[];
    private  int [] pre;
    private  int[] post;
    Queue<Integer> preOrder;
    Queue<Integer> postOrder;
    Deque<Integer> reversePostOrder;
    private  int preCounter;
    private  int postCounter;

    DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre = new int[G.V()];
        post = new int[G.V()];
        preOrder = new ArrayDeque<>();
        postOrder = new ArrayDeque<>();
        reversePostOrder = new ArrayDeque<>();

        for (int v = 0; v < G.V(); v++){
            if(!marked[v]) dfs(G,v);
        }
    }

    private  void dfs(Digraph G,int v){
        marked[v] = true;
        preOrder.add(v);
        pre[v]=preCounter++;
        for (int w : G.adj(v)){
            if (!marked[w]) {
                dfs(G,w);
            }
        }
        post[v]=postCounter++;
        postOrder.add(v);
    }

    public  Iterable<Integer> pre(){
        return  preOrder;
    }

    public Iterable<Integer> post(){
        return  postOrder;
    }

    public Iterable<Integer> reversePostOrder(){
        for (int w : postOrder){
            reversePostOrder.push(w);

        }
        return  reversePostOrder;
    }

    public  int pre(int v){
        return  pre[v];
    }

    public  int post(int v){
        return  post[v];
    }


    public static void  main(String [] args){
        File file = new File("data/tinyDAG.txt");
        try{
            Scanner scr = new Scanner(file);
            Digraph G = new Digraph(scr);
            System.out.println(G);

            DepthFirstOrder dfo = new DepthFirstOrder(G);
            System.out.println("v  pre    post  ");
            System.out.println("-------------- ");
            for (int v =0;v<G.V();v++){
                System.out.format("%d   %d    %d ",v,dfo.pre(v),dfo.post(v));
                System.out.println();
            }
            System.out.print("Pre Order ");

            for (int v : dfo.pre()){
                System.out.print (v +" ");
            }
            System.out.println("");
            System.out.print("Post Order ");

            for (int v : dfo.post()){
                System.out.print (v +" ");
            }
            System.out.println("");
            System.out.print("Reverse post Order ");

            for (int v : dfo.reversePostOrder()){
                System.out.print (v +" ");
            }


        }catch (FileNotFoundException e){
            e.printStackTrace();

        }
    }

}
