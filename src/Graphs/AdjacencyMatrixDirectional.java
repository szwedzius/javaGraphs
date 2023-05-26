import Exceptions.NoEdgeInGraphException;
import Exceptions.NoVertexInGraphException;
import Exceptions.WrongGraphTypeException;

public class AdjacencyMatrixDirectional extends AdjacencyMatrixUni implements Graph {
    AdjacencyMatrixDirectional(int vertexAmount) {
        super(vertexAmount);
    }

    @Override
    public void addEdge(int source, int destination) throws NoVertexInGraphException {
        if (adjMatrix[0][source] != 1 || adjMatrix[0][destination] != 1) {
            throw new NoVertexInGraphException();
        }
        adjMatrix[source][destination] = 1;
    }

    @Override
    public void removeEdge(int source, int destination) throws NoEdgeInGraphException {
        if (adjMatrix[source][destination] != 1) {
            throw new NoEdgeInGraphException();
        }
        adjMatrix[source][destination] = 0;
    }

    @Override
    public void removeEdge(Edge edge) throws NoEdgeInGraphException, WrongGraphTypeException {
        int source = edge.getSource();
        int destination = edge.getDestination();
        if (edge.getWeight() != 0) {
            throw new WrongGraphTypeException();
        }
        if (adjMatrix[source][destination] != 1) {
            throw new NoEdgeInGraphException();
        }
        adjMatrix[source][destination] = 0;
    }
}
