package graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/03/19
 * Time:    11:24 PM
 */
public class DepthFirstDirected<T> {

  boolean marked[] ;
  Map<T, T> edgeTo = new HashMap<>();

  DepthFirstDirected(DirectedGraph G, T s) {
    marked = new boolean[G.V()];
    dfs(G,s);
  }

  public void dfs(DirectedGraph G, T v) {

  }

}
