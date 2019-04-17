package ninjacart;

import com.peace.dp.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    06/04/19
 * Time:    10:51 AM
 */
public class MinimumHops {

  public static void main(String[] args) {

    Character start  = '5';
    Character [] input = {'9','4','3','1','4'};

    Character [][]  keyPad = {
        {'1','2','3'},
        {'4','5','6'},
        {'7','8','9'},
        {'*','0','#'}
    };

    System.out.println( start + "" + findMinHops(keyPad,input, start));

  }



  public static String findMinHops(Character [][] keyPad, Character [] input, Character start) {
    Map<Character,Set<Character>>  adjacencyList = buildAdjacencyList(keyPad);
    Character source = start;
    StringBuilder str = new StringBuilder();
    for (int i = 0; i <  input.length; i++) {
      BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(adjacencyList,source);
      breadthFirstSearch.bfs(source, input[i]);
      String path =  breadthFirstSearch.pathTo(input[i]);
      str.append( path );
      source = input[i];
    }

    return str.toString();

  }


  public static Map<Character,Set<Character>> buildAdjacencyList(Character [][]  keyPad) {

    int xDirectionDistance [] =  {1, 2, -2, -1,-2, 2,-1,  1};
    int yDirectionDistance []  = {2, 1,  1, -2,-1,-1, 2, -2 };

    int totalPossibleMoves = xDirectionDistance.length;
    int rows = keyPad.length;
    int columns = keyPad[0].length;
    Map<Character,Set<Character>>  adjacencyMatrix = new HashMap<>();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j <  columns ; j++) {
        Character val = keyPad[i][j];
         for (int k = 0; k <totalPossibleMoves; k++ ) {
           if (i+xDirectionDistance[k] >= 0 && i + xDirectionDistance[k] <rows
               && j + yDirectionDistance[k] >= 0 && j + yDirectionDistance[k] < columns) {
             if(adjacencyMatrix.get(val) == null) {
               adjacencyMatrix.put(val, new LinkedHashSet<>());
             }
             adjacencyMatrix.get(val).add(keyPad[i+xDirectionDistance[k]] [j + yDirectionDistance[k]]);
           }
         }
      }
    }

    return adjacencyMatrix;

  }


}
