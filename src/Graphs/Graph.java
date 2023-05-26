import Exceptions.NoVertexInGraphException;
import Exceptions.WrongGraphTypeException;

import java.util.*;

public interface Graph {
    void addVertex(int vertex);

    default void addEdge(int source, int destination) throws Exception {
    }

    default void addEdge(int source, int destination, int weight) {
    }

    void removeVertex(int vertex) throws Exception;

    void removeEdge(int source, int destination) throws NoVertexInGraphException;

    void removeEdge(Edge edge) throws NoVertexInGraphException;

    List<Integer> getVertices();

    List<Edge> getEdges();

    List<Integer> getNeighbors(int vertex);

    boolean isVertex(int vertex);

    default boolean isEdge(int vertex1, int vertex2) throws WrongGraphTypeException {
        throw new WrongGraphTypeException();
    }

    default boolean isEdge(int vertex1, int vertex2, int weight) throws WrongGraphTypeException {
        throw new WrongGraphTypeException();
    }

    int getDegree(int vertex);

    List<Integer> DFS(int start_vertex);

    List<Integer> BFS(int start_vertex);

}
