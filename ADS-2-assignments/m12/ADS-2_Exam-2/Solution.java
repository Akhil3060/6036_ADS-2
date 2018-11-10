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
                System.out.println(dsp1.distTo[b] + dsp2.distTo[c]);

                String str = line[0] + " ";
                // System.out.println(dsp1.pathTo(b));
                // for (Edge e1 : dsp1.pathTo(b)) {
                //     str += e1.either() + " ";
                // }
                // System.out.println("sss");
                int var1 = a;
                int var3=0;
                for (Edge e1 : dsp1.pathTo(b)) {
                    int var2 = e1.either();
                    if (var1 == var2) {
                        str += e1.other(var2) + " ";
                    } else {
                        str += var2 + " ";
                    }
                    var1 = var2;
                    var3=var1;
                    // str += e1.either() + " ";
                }
                // str += "qqqq";
                 var1 = var3;
                for (Edge e1 : dsp2.pathTo(c)) {
                    int var2 = e1.either();
                    if (var1 == var2) {
                        str += e1.other(var2) + " ";
                    } else {
                        str += var2 + " ";
                    }
                    var1 = var2;
                    // str += e1.either() + " ";
                }


                // for (Edge e2 : sp2.pathTo(Integer.parseInt(place[2]))) {
                //     int temp = e2.either();
                //     if (i == temp) {
                //         str += e2.other(temp) + " ";
                //     } else {
                //         str += temp + " ";
                //     }
                //     i = temp;
                // }
                System.out.println(str);


                // System.out.println(dsp3.pathTo(b));
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
