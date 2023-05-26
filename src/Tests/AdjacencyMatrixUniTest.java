import Exceptions.NoEdgeInGraphException;
import Exceptions.NoVertexInGraphException;
import Exceptions.WrongGraphTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyMatrixUniTest {

    Graph testGraph;

    @BeforeEach
    void setUp() throws Exception {
        testGraph = new AdjacencyMatrixUni(10);
        int[] vertices = {1,2,3,4,5,6,7,8};
        for (int vertex : vertices) {
            testGraph.addVertex(vertex);
        }
        testGraph.addEdge(1,4);
        testGraph.addEdge(2,3);
        testGraph.addEdge(5,7);
        testGraph.addEdge(3,8);
        testGraph.addEdge(1,3);
    }

    @Test
    void checkIfRemovesVertexFromGetVertices() throws Exception {
        testGraph.removeVertex(5);
        assertEquals(List.of(1,2,3,4,6,7,8),testGraph.getVertices());
    }

    @Test
    void checkIfRemovesEdgesOfCurrentVertex() throws Exception {
        testGraph.removeVertex(5);
        assertEquals(0,testGraph.getDegree(5));
    }

    @Test
    void checkIfRemovesDoesntRemoveNonExistantVertex() {
        assertThrows(NoVertexInGraphException.class, () -> testGraph.removeVertex(9));
    }

    @Test
    void baseTestCaseOfRemoveEdge() throws WrongGraphTypeException, NoEdgeInGraphException {
        testGraph.removeEdge(5,7);
        assertFalse(testGraph.isEdge(5, 7));
    }

    @Test
    void NoEdgeInGraphExceptionRemoveEdge() {
        assertThrows(NoEdgeInGraphException.class,() -> testGraph.removeEdge(1,7));
    }

    @Test
    void removeEdgeWithEdgeClassBaseTest() throws NoEdgeInGraphException, WrongGraphTypeException {
        testGraph.removeEdge(new Edge(5,7));
        assertFalse(testGraph.isEdge(5, 7));
    }

    @Test
    void removeEdgeWithEdgeClassNoEdgeInGraph() {
        assertThrows(NoEdgeInGraphException.class,() -> testGraph.removeEdge(new Edge(1,7)));
    }

    @Test
    void removeEdgeWithEdgeClassWrongGraphType() {
        assertThrows(WrongGraphTypeException.class,() -> testGraph.removeEdge(new Edge(1,7,3)));
    }

    @Test
    void getVerticesBaseTest() throws NoVertexInGraphException {
        assertEquals(List.of(1,2,3,4,5,6,7,8),testGraph.getVertices());
    }

    @Test
    void getEdges() {
    }

    @Test
    void getNeighborsBaseTest() throws NoVertexInGraphException {
        assertEquals(List.of(1,2,8),testGraph.getNeighbors(3));
    }

    @Test
    void getNeighborsNoVertexInGraphTest() {
        assertThrows(NoVertexInGraphException.class, ()-> testGraph.getNeighbors(100));
    }

    @Test
    void isVertexBaseTest() {
        assertTrue(testGraph.isVertex(5));
    }

    @Test
    void isVertexFalseTest() {
        assertFalse(testGraph.isVertex(9));
    }

    @Test
    void isVertexEdgeCase(){
        assertThrows(IndexOutOfBoundsException.class, ()-> testGraph.isVertex(1000));
    }

    @Test
    void getDegree() throws NoVertexInGraphException {
        assertEquals(3,testGraph.getDegree(3));
    }

    @Test
    void getDegreeZeroTest() throws NoVertexInGraphException {
        assertEquals(0,testGraph.getDegree(6));
    }

}