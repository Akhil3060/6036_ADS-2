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
                Edge di = new Edge(a,b,c);
                Edge di1 = new Edge(b,a,c);
                // if (a != b) {
                    g.addEdge(di1);
                    g.addEdge(di);
                // }
        }
        // System.out.println(g.display());
        System.out.println(g);
        // String caseToGo = null;
        // switch (caseToGo) {
        // case "Graph":
        //     //Print the Graph Object.
        //     break;

        // case "DirectedPaths":
        //     // Handle the case of DirectedPaths, where two integers are given.
        //     // First is the source and second is the destination.
        //     // If the path exists print the distance between them.
        //     // Other wise print "No Path Found."
        //     break;

        // case "ViaPaths":
        //     // Handle the case of ViaPaths, where three integers are given.
        //     // First is the source and second is the via is the one where path should pass throuh.
        //     // third is the destination.
        //     // If the path exists print the distance between them.
        //     // Other wise print "No Path Found."
        //     break;

        // default:
        //     break;
        // }

    }
}
