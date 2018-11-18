import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(a, b, sc);
        KruskalMST kmst = new KruskalMST(ewg);
        System.out.printf("%.5f", kmst.weight());

    }
}


/**
 * Class for kruskal mst.
 */
class KruskalMST {
    /**
     * double var.
     */
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    /**
     * weight.
     */
    private double weight;
    /**
     * Queue of type EDGE.
     */
    private Queue<Edge> mst = new Queue<Edge>();
    /**
     * Constructs the object.
     *
     * @param      g     { parameter_description }
     */
    KruskalMST(final EdgeWeightedGraph g) {
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : g.edges()) {
            pq.insert(e);
        }

        UF uf = new UF(g.V());
        while (!pq.isEmpty() && mst.size() < g.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.enqueue(e);
                weight += e.weight();
            }
        }
        assert check(g);
    }
    /**
     * Edges.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * weight.
     *
     * @return     { description_of_the_return_value }
     */
    public double weight() {
        return weight;
    }
    /**
     * check.
     *
     * @param      g     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check(final EdgeWeightedGraph g) {

        // check total weight
        double total = 0.0;
        for (Edge e : edges()) {
            total += e.weight();
        }
        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf(
                "Weight of edges does not equal weight(): %f vs. %f\n",
                total, weight());
            return false;
        }
        UF uf = new UF(g.V());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }
        for (Edge e : g.edges()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new UF(g.V());
            for (Edge f : mst) {
                int x = f.either(), y = f.other(x);
                if (f != e) {
                    uf.union(x, y);
                }
            }

            for (Edge f : g.edges()) {
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f
                                           + " violates cut"
                                           + " optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }

}
