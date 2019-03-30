package graphs;

import java.util.Map;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/01/19
 * Time:    10:47 AM
 */
public class Graph {

  Map<Vertex,Set<Vertex>> adjacencyList;

  public  void addVertex(Vertex v) {

  }

  private class Vertex<T> {
    T data;

    Vertex(T data) {
      this.data = data;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Vertex<?> vertex = (Vertex<?>) o;

      return data.equals(vertex.data);
    }

    @Override
    public int hashCode() {
      return data.hashCode();
    }
  }

  private  static class Edge {
    Vertex v1;
    Vertex v2;

    Edge(Vertex v1, Vertex v2) {
      this.v1 = v1;
      this.v2 = v2;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Edge edge = (Edge) o;

      if (!v1.equals(edge.v1)) return false;
      return v2.equals(edge.v2);
    }

    @Override
    public int hashCode() {
      int result = v1.hashCode();
      result = 31 * result + v2.hashCode();
      return result;
    }
  }
}
