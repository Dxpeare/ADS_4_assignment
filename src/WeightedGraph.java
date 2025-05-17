
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> src = vertices.get(source);
        Vertex<V> dest = vertices.get(destination);

        if (src != null && dest != null) {
            src.addAdjacentVertex(dest, weight);
            dest.addAdjacentVertex(src, weight); // Если граф неориентированный
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}
