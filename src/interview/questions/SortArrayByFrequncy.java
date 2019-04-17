package interview.questions;

import com.peace.dp.LIS;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/04/19
 * Time:    9:38 PM
 */
public class SortArrayByFrequncy {
  private  int ascending = 1 ;
  private  int descending = 0 ;


  public static void main(String[] args) {
    int arr[] = new int []{ -1,2,3,4,2,2,2,4,5,6,-1,-20,-10,-5,-5};
    sort(arr);
  }

  public static void sort(int arr[]) {
    HashMap<Integer,Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length ; i++) {
      map.put(arr[i],map.getOrDefault(arr[i],0)+1);
    }
    List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {

      @Override
      public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
        if (o1.getValue() == o2.getValue()) {
          return o1.getKey().compareTo(o2.getKey());
        }
        return o1.getValue().compareTo(o2.getValue());

      }
    });

    list.forEach( a ->
                      System.out.println("key :: " + a.getKey() + ", value ::: " + a.getValue()));


/*
    map = list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                 (a, b) -> b, LinkedHashMap::new));

    map.forEach((k,v) ->
                     System.out.println("key :: " + k + ", value ::: " + v));
*/
  }

}
