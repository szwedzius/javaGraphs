import java.awt.*;

public interface Graph {
    void addVertex(int vertex);

    default void addEdge(int source, int destination) {
    }

    default void addEdge(int source, int destination, int weight) {
    }

    void removeVertex(int vertex);

    void removeEdge(int source, int destination);

    List getVertices();

    List getEdges();

    List getNeighbors(int vertex);

    boolean isVertex(int vertex);

    default boolean isEdge(int vertex1, int vertex2) throws Exception {
        throw new Exception("wrong method for this type of graph");
    }

    default boolean isEdge(int vertex1, int vertex2, int weight) throws Exception {
        throw new Exception("wrong method for this type of graph");
    }

    int getDegree(int vertex);

    List DFS(int start_vertex);

    List BFS(int start_vertex);
}
