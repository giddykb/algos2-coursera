package com.peace.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    06/11/18
 * Time:    6:22 PM
 */
public class TargetSum {

  public static void main(String[] args) {
    int [] nums = {1,1,1,1,1};
    int T = 1;
    System.out.println(targetSum(nums, T));
  }

  public static  int targetSum( int[] nums, int T) {
    return targetSum(nums, T, 0, 0);
  }

  public static  int targetSum( int[] nums, int T, int sum, int idx) {
    if ( idx == nums.length) {
      return sum == T ? 1: 0;
    }
    return targetSum(nums, T ,  sum + nums[idx] , idx+1 ) +
        targetSum(nums, T, sum - nums[idx],idx+1);
  }

  private static int topDown(int nums[] , int T) {
    Map<Integer,Map<Integer,Integer>> cache = new HashMap<>();
    return topDown(nums, T , 0 , 0, cache);
  }

  private static int topDown(int nums[] , int T,int sum, int idx, Map<Integer,Map<Integer,Integer>> cache) {
    if ( idx == nums. length) {
      return sum == T ? 1 : 0;
    }

    if ( !cache.containsKey(idx)) {
      cache.put(idx, new HashMap<Integer,Integer>());
    }

    Integer cached = cache.get(idx).get(sum);
    if ( cache != null) return cached;
    int toReturn = topDown(nums, T, sum + nums[idx], idx+1,cache)
        + topDown(nums,T, sum - nums[idx],idx+1 ,cache);
    cache.get(idx).put(sum,toReturn);
    return toReturn;

  }

}
