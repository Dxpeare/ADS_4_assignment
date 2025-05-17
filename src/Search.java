
import java.util.List;

public abstract class Search<V> {
    protected final V start;
    protected final WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph, V start) {
        this.graph = graph;
        this.start = start;
    }

    public abstract List<V> getPath(V end);
}
