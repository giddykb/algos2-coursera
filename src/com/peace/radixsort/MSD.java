package com.peace.radixsort;

/**
 * Created by girishkumarbanda on 07/04/2017 AD.
 */
public class MSD {

    private  static  String aux[];
    private  static  int R =256;

    public static  void sort(String a[],int d){
        aux = new String[a.length];
        //sort(a,aux,);

    }

    public static  void sort(String a[], String aux[],int lo,int hi,int d){
        if (hi<=lo) return;

        int count []  = new int  [R+2];

        for (int i =lo;i<=hi;i++){
            count[charAt(a[lo],d)+2]++;
        }

        for (int r = 0; r < R+1 ; r++) {
            count[r+1] += count[r];
        }

        for (int i = lo; i <= hi ; i++) {
            int c = charAt(a[lo],d);
            aux[c++]=a[i];
        }

        for (int i = lo; i <=hi ; i++) {
            a[i]=aux[i];
        }

        for (int r = 0; r < R+1 ; r++) {
            sort(a,aux,count[r],lo+count[r+1] -1,d+1);
        }

    }

    private  static int  charAt(String s ,int d){
        if (d<s.length())return s.charAt(d);
        return -1;
    }


}
