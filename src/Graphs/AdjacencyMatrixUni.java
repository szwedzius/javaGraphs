import Exceptions.NoEdgeInGraphException;
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

    public void removeVertex(int vertex) throws NoVertexInGraphException {
        if (adjMatrix[0][vertex] != 1) {
            throw new NoVertexInGraphException();
        }
        for (int i = 0; i < vertices; i++) {
            adjMatrix[i][vertex] = 0;
            adjMatrix[vertex][i] = 0;
        }

    }

    public void removeEdge(int source, int destination) throws NoEdgeInGraphException {
        if (adjMatrix[destination][source] != 1 || adjMatrix[source][destination] != 1) {
            throw new NoEdgeInGraphException();
        }
        adjMatrix[source][destination] = 0;
        adjMatrix[destination][source] = 0;
    }

    @Override
    public void removeEdge(Edge edge) throws NoEdgeInGraphException, WrongGraphTypeException {
        int source = edge.getSource();
        int destination = edge.getDestination();
        if (edge.getWeight() != 0) {
            throw new WrongGraphTypeException();
        }
        if (adjMatrix[destination][source] != 1 || adjMatrix[source][destination] != 1) {
            throw new NoEdgeInGraphException();
        }
        adjMatrix[source][destination] = 0;
        adjMatrix[destination][source] = 0;
    }

    public List<Integer> getVertices() throws NoVertexInGraphException {
        return getNeighbors(0);
    }

    public List<Edge> getEdges() {
        List<Edge> result = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j <= i; j++) {
                if (adjMatrix[i][j] == 1) result.add(new Edge(i, j));
            }
        }
        return result;
    }

    public List<Integer> getNeighbors(int vertex) throws NoVertexInGraphException {
        List<Integer> result = new LinkedList<>();
        if(vertex>vertices){
            throw new NoVertexInGraphException();
        }
        for (int i = 1; i < vertices; i++) {
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

    public int getDegree(int vertex) throws NoVertexInGraphException {
        return getNeighbors(vertex).size();
    }

    public List<Integer> DFS(int start_vertex) {
        return null;
    }

    public List<Integer> BFS(int start_vertex) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(start_vertex);
        List<Integer> visited = new LinkedList<>();
        while (!bfsQueue.isEmpty()) {
            int currentVertex = bfsQueue.poll();
            visited.add(currentVertex);
            for (int i = 1; i < vertices; i++) {
                if (!visited.contains(i) && adjMatrix[currentVertex][i] == 1) {
                    bfsQueue.add(i);
                }
            }
        }
        return visited;
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
