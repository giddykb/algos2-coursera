package ninjacart;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    06/04/19
 * Time:    11:43 AM
 *
 *
 *   {  2, 1, -1, -2, -2, -1,  1,  2 };
     {  1, 2,  2,  1, -1, -2, -2, -1 };
 */
public class BreadthFirstSearch {
  Map<Character,Set<Character>> adjacencyMatrix ;
  Map<Character, Boolean> isVisited = new HashMap();
  Map<Character, Character> edgeTo = new HashMap();

  Character source ;


  BreadthFirstSearch( Map<Character,Set<Character>>  adjacencyMatrix ,  Character source ) {
    this.adjacencyMatrix = adjacencyMatrix;
    this.source = source;
  }

  public void bfs( Character source, Character destination) {
    Queue<Character> queue = new ArrayDeque<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      Character v = queue.remove();
      isVisited.put(v,true);
      for (Character w : adjacencyMatrix.get(v)) {
          if (isVisited.get(w) == null ) {
            queue.add(w);
            edgeTo.put(w,v);
          }
        }

    }
  }

  public String pathTo(Character sink) {
   List<Character>  path = new ArrayList<>();
   StringBuilder str = new StringBuilder();
    for (Character v = sink; !v.equals(source); v =  edgeTo.get(v)) {
      path.add(v);
      str.append(v).append( " ");
    }
    return str.reverse().toString();
  }

}
