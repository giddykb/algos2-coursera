package graphs;

import com.peace.directed.Digraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    16/03/19
 * Time:    10:27 PM
 */

public class DirectedGraph<T extends Comparable<T>>  implements  Comparator<T> {

  private Map<T,Set<T>> adjacencyList = new TreeMap<T,Set<T>>();
  private int V;
  private  int E;

  DirectedGraph(){
    adjacencyList = new HashMap<>();
  }

  public DirectedGraph(Scanner scr) {
    this.V = scr.nextInt();
    this.E = scr.nextInt();

    while (scr.hasNextInt()) {
      T v = (T) scr.next();
      T w = (T) scr.next();
      addEdge(v, w);
    }
  }

  public void addEdge(T v, T w) {
    if(!adjacencyList.containsKey(v)) {
      adjacencyList.put(v,new LinkedHashSet<>());
    }
    E++;
    adjacencyList.get(v).add(w);
  }

  public Set<T> adjacency(T v) {
    return adjacencyList.get(v);
  }

  public DirectedGraph reverse() {
    DirectedGraph reverse = new DirectedGraph();
    adjacencyList.forEach(
        ((k,v) -> v.forEach(t -> reverse.addEdge(t,k)))
    );
    return reverse;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    adjacencyList.forEach(
        (k,v) -> sb.append(k  + " : " + v + "\n")
    );
    return sb.toString();
  }

  public static void main(String[] args) {
    File file = new File("data/tinyDG.txt");
    try {
      Scanner scr = new Scanner(file);
      DirectedGraph G = new DirectedGraph(scr);
      System.out.println(G);
      System.out.println(G.reverse());
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public int V() {
    return adjacencyList.size();
  }

  public int getE() {
    return E;
  }

  @Override
  public int compare(T o1, T o2) {
    return o1.compareTo(o2);
  }

}
