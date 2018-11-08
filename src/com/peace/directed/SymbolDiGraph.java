package com.peace.directed;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by girishkumarbanda on 28/03/2017 AD.
 * @noinspection ALL
 */
public class SymbolDiGraph {

    Map<String,Integer> st;
    String keys[];
    private  Digraph G;

    SymbolDiGraph(String filename, String delimeter){
        st = new HashMap<>();

        Scanner scr = null;
        try {
            scr = new Scanner(new File(filename));
            while(scr.hasNextLine()){
                String [] strArray = scr.nextLine().split(delimeter);
                for (int i =0 ;i< strArray.length;i++){
                    if(!st.containsKey(strArray[i])){
                        st.put(strArray[i],st.size());
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Pass one to find the number of vertices
        // inverted keys mapping
        keys = new String[st.size()];

        for (String key :st.keySet()){
            keys[st.get(key)] = key;
        }
        G = new Digraph(st.size());
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()){
                String [] stArray = sc.nextLine().split(delimeter);

                int v = st.get(stArray[0]);
                for (int i =1 ;i<stArray.length;i++){
                    int w = st.get(stArray[i]);
                    G.addEdge(v,w);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    public Digraph diGraph(){
        return  G;
    }

    public  Iterable<String> keys(){
        return  st.keySet();
    }

    public  int index(String s){
        return  st.get(s);
    }

    public String name(int v){
        return  keys[v];
    }


    public  static  void  main(String[] args){
        String fileName ="data/routes.txt";
        String delimeter=" ";

        SymbolDiGraph sg = new SymbolDiGraph(fileName,delimeter);
        Digraph G  = sg.diGraph();
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
    }
}
