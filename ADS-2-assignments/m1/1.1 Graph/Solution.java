import java.util.Scanner;
import java.util.Arrays;


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
        if (type.equals("List")) {

        } else if (type.equals("Matrix")) {
            int v, e;
            v = sc.nextInt();
            e = sc.nextInt();
            sc.nextLine();
            String[] line = sc.nextLine().split(",");
            int[][] graph = new int[v ][v ];
            int a, b;
            // System.out.println(Arrays.deepToString(graph));
            String[] nodes = new String[2];
            while (sc.hasNext()) {
                nodes = sc.nextLine().split(" ");
                a = Integer.parseInt(nodes[0]);
                b = Integer.parseInt(nodes[1]);
                graph[a][b] = 1;
                graph[b][a] = 1;
            }
            System.out.println(v + " vertices, " + e + " edges");
            // System.out.println(Arrays.deepToString(graph));
            for (int[] each : graph) {
                for (int each2 : each) {
                    System.out.print(each2 + " ");
                }
                System.out.println();
            }

        }
    }
}
