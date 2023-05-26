public class Main {
    public static void main(String[] args) throws Exception {
        Graph g1 = new AdjacencyMatrixUni(10);
        int[] vertex = {1,2,3,5,7,9};
        for (int i : vertex) {
            g1.addVertex(i);
        }
        g1.addEdge(1,2);
        g1.addEdge(3,2);
        g1.addEdge(3,7);
        g1.addEdge(1,9);
        System.out.println(g1);
    }
}