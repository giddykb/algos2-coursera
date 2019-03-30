package com.peace.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/03/19
 * Time:    9:39 PM
 */
public class LIS {

  public static void main(String[] args) {
    LIS lis = new LIS();
    int a[] = {10,9,2,5,3,7,101,18};
    System.out.println(lis.lengthOfLIS(a));
    lis.findAllSubsequence(a);
  }
  public int lengthOfLIS(int[] nums) {
    int LIS [] = new int [nums.length];
    Arrays.fill(LIS, 1);
    for(int i =0 ;i < nums.length; i++) {
      for ( int j =0 ; j < i; j++) {
        if ( nums[j] < nums[i]) {
          LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
        }
      }
    }

    int max = 0;
    for ( int i = 0 ;i < LIS.length; i++ ) {
      max = Math.max(LIS[i],max);
    }

    return max;
  }

  public void findAllSubsequence(int nums[]) {
    int LIS[]  = new int[nums.length];
    TreeMap<Integer,ArrayList<Integer>> result = new TreeMap<>();
    for (int i = 0; i <LIS.length ; i++) {
      ArrayList<Integer> initalList = new ArrayList();
      initalList.add(nums[i]);
      result.put(i,initalList);

    }
    Arrays.fill(LIS, 1);
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j <i ; j++) {
        if (nums[j] < nums[i] && LIS[i] < 1 + LIS[j]) {
          ArrayList<Integer> temp = new ArrayList<>();
          temp.addAll(result.get(j));
          temp.add(nums[i]);
          result.put(i, temp);

        }
      }
    }

    result.forEach(
        (k,v) -> System.out.println( k + " ::: " + Arrays.asList(v))
    );
  }

}
