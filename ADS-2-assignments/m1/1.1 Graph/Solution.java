import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;


interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}


class Solution {
    Solution() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        String[] nodes = new String[2];
        int a, b;
        if (type.equals("List")) {
            HashMap<String, ArrayList<String>> hmap = new HashMap<>();
            ArrayList<String> arrlist = new ArrayList<>();
            int v = 0, e1 = 0;
            // System.out.println("v =" + v);
            v = Integer.parseInt(sc.nextLine());
            e1 = Integer.parseInt(sc.nextLine());
            int[][] graph = new int[v][v];

            String[] line = sc.nextLine().split(",");

            System.out.println(line[1]);
            // System.out.println("aaaaa" + graph.length);

            while (sc.hasNext()) {
                nodes = sc.nextLine().split(" ");
                a = Integer.parseInt(nodes[0]);
                b = Integer.parseInt(nodes[1]);

                // try {
                graph[a][b] = 1;
                graph[b][a] = 1;
                // } catch (Exception e) {
                // System.out.println("A " + a + "  b = " + b);
                // }

            }
            for (int[] each : graph) {
                for (int each2 : each) {
                    if (each2 == 1) {
                        arrlist.add(nodes[each2]);
                        // hmap.put()
                        // arrlist.put(nodes[]);
                    }
                    hmap.put(nodes[each[0]], arrlist);
                    System.out.println("arrlist " + arrlist);
                }
                // System.out.println();
            }
            System.out.println(hmap.get("Andhra Pradesh"));


        } else if (type.equals("Matrix")) {
            int v = 0, e1 = 0;
            v = Integer.parseInt(sc.nextLine());
            e1 = Integer.parseInt(sc.nextLine());
            // System.out.println("e =" + e1);

            String[] line = sc.nextLine().split(",");
            int[][] graph = new int[v][v];

            // System.out.println(Arrays.deepToString(graph));

            while (sc.hasNext()) {
                nodes = sc.nextLine().split(" ");
                a = Integer.parseInt(nodes[0]);
                b = Integer.parseInt(nodes[1]);
                if (a != b) {
                    graph[a][b] = 1;
                    graph[b][a] = 1;
                }

            }
            if (v == 1) {
                System.out.println(v + " vertices, " + (e1 - 1) + " edges");

            } else {
                System.out.println(v + " vertices, " + e1 + " edges");

            }
            // System.out.println(Arrays.deepToString(graph));
            if (v <= 1 ) {
                System.out.println("No edges");
            } else {
                for (int[] each : graph) {
                    for (int each2 : each) {
                        System.out.print(each2 + " ");
                    }
                    System.out.println();
                }
            }


        }
    }
}
