public class Main {
    public static void main(String[] args) throws Exception {
        Graph g1 = new AdjacencyMatrixUni(10);
        int[] vertex = {1,2,3,4,5,6};
        for (int i : vertex) {
            g1.addVertex(i);
        }
        g1.addEdge(1,2);
        g1.addEdge(3,2);
        g1.addEdge(3,5);
        g1.addEdge(1,6);
        System.out.println("BFS");
        g1.BFS(3).forEach(x -> System.out.print(x + " "));
        System.out.println("\n");
        System.out.println(g1);
    }
}