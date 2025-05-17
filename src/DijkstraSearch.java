
import java.util.*;

public class DijkstraSearch<V> extends Search<V> {

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(graph, start);
    }

    @Override
    public List<V> getPath(V end) {
        Map<V, V> parentMap = new HashMap<>();
        Map<V, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(vertex -> distances.getOrDefault(vertex.getData(), Double.POSITIVE_INFINITY)));

        for (V vertex : graph.getVertices().keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        Vertex<V> startVertex = graph.getVertex(start);
        if (startVertex != null) {
            pq.add(startVertex);
        } else {
            throw new IllegalArgumentException("Start vertex not found in the graph!");
        }

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> neighbor : current.getAdjacentVertices().entrySet()) {
                double newDist = distances.get(current.getData()) + neighbor.getValue();

                if (newDist < distances.getOrDefault(neighbor.getKey().getData(), Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor.getKey().getData(), newDist);
                    parentMap.put(neighbor.getKey().getData(), current.getData());
                    if (!pq.contains(neighbor.getKey())) {
                        pq.add(neighbor.getKey());
                    }
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
