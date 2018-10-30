/**
 * List of graphs.
 */
public class GraphList implements Graph {
    /**
     * NEWLINE.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * V.
     */
    private final int V;
    /**
     * E.
     */
    private int E;
    /**
     * BAG.
     */
    private Bag<Integer>[] adj;

    /**
     * Initializes an empty GraphList with {@code V} vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  V number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public GraphList(final int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number"
                                               + " of vertices must"
                                               + " be nonnegative");
        }
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Returns the number of vertices in this GraphList.
     *
     * @return the number of vertices in this GraphList
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this GraphList.
     *
     * @return the number of edges in this GraphList
     */
    public int E() {
        return E;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    /**
     * validateVertex.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v
                                               + " is not between 0 and "
                                               + (V - 1));
        }
    }


    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        // validateVertex(v);
        // validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        int count = 0;
        for (int i : adj[v]) {
            if (i == w) {
                count += 1;
                break;
            }
        }
        for (int i : adj[w]) {
            if (i == v) {
                count += 1;
                break;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }



    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }


    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int degree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }



    /**
     * Returns a string representation of this GraphList.
     *
     * @param      data  The data
     *
     * @return     adjacency lists
     */
    public String display(final String[] data) {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges" + NEWLINE);
        if (E > 0) {
            for (int v = 0; v < V; v++) {
                s.append(data[v] + ": ");
                for (int w : adj[v]) {
                    s.append(data[w] + " ");
                }
                s.append(NEWLINE);
            }
        } else {
            s.append("No edges");
        }
        return s.toString();
    }
}
