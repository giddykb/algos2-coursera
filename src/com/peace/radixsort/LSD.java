package com.peace.radixsort;

import com.peace.mst.Edge;
import com.peace.mst.EdgeWeightedGraph;
import com.peace.mst.KruskalMST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by girishkumarbanda on 04/04/2017 AD.
 * @noinspection ALL
 */
public class LSD {

    private  static  final int R =256;
    private int count [];

    public LSD(String [] a,int W){
        int N =a.length;
        String aux[] = new String [N];

        for (int d = W-1; d >=0 ; d--) {
            count = new int [R+1];

            //compute frequency
            for (int i = 0;i< N;i++){
                    char c =a[i].charAt(d);
                    count[c+1]++;
            }

            // compute cumulates
            for (int r = 0; r < R ; r++) {
                count[r+1]+=count[r];
            }

            // move data to auxilary array
            for (int i = 0; i < N ; i++) {
                char c =a[i].charAt(d);
                aux[count[c]++] =a[i];
            }

            //copy to original array
            for (int i =0;i< N;i++){
                a[i]=aux[i];
            }

        }

    }

    public static void main(String args[]){
        File file = new File("data/words.txt");
        try {
            Scanner scr = new Scanner(file);
            scr.useDelimiter("\\Z");
           // String a[] = scr.next().split(" ");
            String a [] ={"abc" ,"cba","bbc","bca","cab","cca","ccc"};

            LSD  lsd = new LSD(a,a[0].length());

            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
