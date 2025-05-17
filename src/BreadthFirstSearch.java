
import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        super(graph, start);
    }

    @Override
    public List<V> getPath(V end) {
        Map<V, V> parentMap = new HashMap<>();
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            if (current.equals(end)) break;

            for (Vertex<V> neighbor : graph.getVertex(current).getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor.getData())) {
                    queue.add(neighbor.getData());
                    visited.add(neighbor.getData());
                    parentMap.put(neighbor.getData(), current);
                }
            }
        }

        List<V> path = new ArrayList<>();
        for (V at = end; at != null; at = parentMap.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path.get(0).equals(start) ? path : Collections.emptyList();
    }
}
