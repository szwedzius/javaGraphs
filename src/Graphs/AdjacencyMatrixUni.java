import Exceptions.NoVertexInGraphException;
import Exceptions.WrongGraphTypeException;

import java.util.*;

public class AdjacencyMatrixUni implements Graph {

    int[][] adjMatrix;
    int vertices;

    AdjacencyMatrixUni(int vertexAmount) {
        adjMatrix = new int[vertexAmount + 1][vertexAmount + 1];
        vertices = vertexAmount;
    }

    public void addVertex(int vertex) {
        adjMatrix[0][vertex] = 1;
        adjMatrix[vertex][0] = 1;
    }

    public void addEdge(int source, int destination) throws NoVertexInGraphException {
        if (adjMatrix[0][source] != 1 || adjMatrix[0][destination] != 1) {
            throw new NoVertexInGraphException();
        }
        adjMatrix[destination][source] = 1;
        adjMatrix[source][destination] = 1;
    }

    public void removeVertex(int vertex) throws Exception {
        if (adjMatrix[0][vertex] != 1) {
            throw new NoVertexInGraphException();
        }
        adjMatrix[0][vertex] = 0;
        adjMatrix[vertex][0] = 0;
    }

    public void removeEdge(int source, int destination) throws NoVertexInGraphException {
        if (adjMatrix[0][source] != 1 || adjMatrix[0][destination] != 1) {
            throw new NoVertexInGraphException();
        }
        adjMatrix[source][destination] = 0;
        adjMatrix[destination][source] = 0;
    }

    @Override
    public void removeEdge(Edge edge) throws NoVertexInGraphException {
        int source = edge.getSource();
        int destination = edge.getDestination();
        if (adjMatrix[0][source] != 1 || adjMatrix[0][destination] != 1) {
            throw new NoVertexInGraphException();
        }
        adjMatrix[source][destination] = 0;
        adjMatrix[destination][source] = 0;
    }

    public List<Integer> getVertices() {
        return getNeighbors(0);
    }

    public List<Edge> getEdges() {
        List<Edge> result = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j <= i; j++) {
                if (adjMatrix[i][j] == 1)
                    result.add(new Edge(i, j));
            }
        }
        return result;
    }

    public List<Integer> getNeighbors(int vertex) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[vertex][i] == 1) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isVertex(int vertex) {
        return adjMatrix[0][vertex] == 1;
    }

    public boolean isEdge(int vertex1, int vertex2) {
        return adjMatrix[vertex1][vertex2] == 1;
    }

    public int getDegree(int vertex) {
        return getNeighbors(vertex).size();
    }

    public List<Integer> DFS(int start_vertex) {
        return null;
    }

    public List<Integer> BFS(int start_vertex) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                result.append(adjMatrix[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
