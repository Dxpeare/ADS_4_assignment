public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("Kyzylorda");
        graph.addVertex("Shymkent");
        graph.addVertex("Atyrau");
        graph.addVertex("Kostanay");
        graph.addVertex("Astana");

        graph.addEdge("Kyzylorda", "Shymkent", 6);
        graph.addEdge("Shymkent", "Atyrau", 10);
        graph.addEdge("Atyrau", "Kostanay", 15);
        graph.addEdge("Kostanay", "Astana", 5);
        graph.addEdge("Astana", "Kyzylorda", 20);

        Search<String> bfs = new BreadthFirstSearch<>(graph, "Kyzylorda");
        System.out.println("BFS Path: " + bfs.getPath("Astana"));

        Search<String> dfs = new DepthFirstSearch<>(graph, "Kyzylorda");
        System.out.println("DFS Path: " + dfs.getPath("Astana"));

        Search<String> dijkstra = new DijkstraSearch<>(graph, "Kyzylorda");
        System.out.println("Dijkstra Path: " + dijkstra.getPath("Astana"));
    }
}
