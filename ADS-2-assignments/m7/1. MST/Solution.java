import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(a, b, sc);
        KruskalMST kmst = new KruskalMST(ewg);
        System.out.printf("%.5f", kmst.weight());

    }
}



class KruskalMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    private double weight;
    private Queue<Edge> mst = new Queue<Edge>();
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

    public Iterable<Edge> edges() {
        return mst;
    }


    public double weight() {
        return weight;
    }
    private boolean check( EdgeWeightedGraph g) {

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
                           + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }

}
