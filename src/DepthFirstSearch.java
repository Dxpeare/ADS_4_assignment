
import java.util.*;

public class DepthFirstSearch<V> extends Search<V> {

    private final Set<V> visited = new HashSet<>();
    private final Map<V, V> parentMap = new HashMap<>();

    public DepthFirstSearch(WeightedGraph<V> graph, V start) {
        super(graph, start);
        dfs(start);
    }

    private void dfs(V current) {
        visited.add(current);
        for (Vertex<V> neighbor : graph.getVertex(current).getAdjacentVertices().keySet()) {
            if (!visited.contains(neighbor.getData())) {
                parentMap.put(neighbor.getData(), current);
                dfs(neighbor.getData());
            }
        }
    }

    @Override
    public List<V> getPath(V end) {
        List<V> path = new ArrayList<>();
        for (V at = end; at != null; at = parentMap.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path.get(0).equals(start) ? path : Collections.emptyList();
    }
}
