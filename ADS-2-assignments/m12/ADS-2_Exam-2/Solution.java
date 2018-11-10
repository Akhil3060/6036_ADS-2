import java.util.Scanner;
public class Solution {

    // void Graph(){

    // }

    public static void main(String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner sc = new Scanner(System.in);
        int v = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(v);
        for (int i = 0; i < e; i++) {
            String[] line = sc.nextLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            Double c = Double.parseDouble(line[2]);
            Edge di = new Edge(a, b, c);
            // Edge di1 = new Edge(b,a,c);
            // if (a != b) {
            // g.addEdge(di1);
            g.addEdge(di);
            // }
        }
        // System.out.println(g.display());
        String caseToGo =  sc.nextLine();
        switch (caseToGo) {
        case "Graph":
            System.out.println(g);
            //Print the Graph Object.
            break;

        case "DirectedPaths":
            String[] line = sc.nextLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(g, b);
            if (!dsp.hasPathTo(a)) {
                System.out.println("No Path Found.");
            } else {
                System.out.println(dsp.distTo[a]);

            }
            // Handle the case of DirectedPaths, where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            break;

        case "ViaPaths":
            line = sc.nextLine().split(" ");
            a = Integer.parseInt(line[0]);
            b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            DijkstraUndirectedSP dsp1 = new DijkstraUndirectedSP(g, a);
            DijkstraUndirectedSP dsp2 = new DijkstraUndirectedSP(g, b);
            // DijkstraUndirectedSP dsp3 = new DijkstraUndirectedSP(g, c);
            if (!dsp1.hasPathTo(c) || !dsp2.hasPathTo(c)) {
                System.out.println("No Path Found.");
            } else {
                System.out.println(dsp1.distTo[b]+dsp2.distTo[c]);

                // System.out.println(dsp2.distTo[c]);
                // System.out.println(dsp3.distTo[a]);
                // System.out.println(dsp1.edgeTo[b].either());
                System.out.println(dsp2.edgeTo[c]);
                // System.out.println(dsp1.edgeTo[c]);

                // System.out.println(dsp1.pathTo(b));
                // System.out.println(dsp2.pathTo(c));

            }


            // Handle the case of ViaPaths, where three integers are given.
            // First is the source and second is the via is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            break;

        default:
            break;
        }

    }
}
