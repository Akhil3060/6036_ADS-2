import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;


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
        int v, e1;
        if (type.equals("List")) {

            v = Integer.parseInt(sc.nextLine());
            e1 = Integer.parseInt(sc.nextLine());
            String[] input = sc.nextLine().split(",");

            GraphList g = new GraphList(v);
            for (int i = 0; i < e1; i++) {
                String[] add = sc.nextLine().split(" ");
                int a = Integer.parseInt(add[0]);
                int b = Integer.parseInt(add[1]);
                if (a != b && !g.hasEdge(a, b)) {
                    g.addEdge(a, b);
                }
            }
            System.out.println(g.display(input));


            // HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
            // ArrayList<String> arrlist = new ArrayList<>();
            // int v = 0, e1 = 0;
            // // System.out.println("v =" + v);
            // v = Integer.parseInt(sc.nextLine());
            // e1 = Integer.parseInt(sc.nextLine());


            // int[][] graph = new int[v][v];

            // String[] line = sc.nextLine().split(",");

            // // System.out.println(line[1]);
            // // System.out.println("aaaaa" + graph.length);

            // while (sc.hasNext()) {
            //     nodes = sc.nextLine().split(" ");
            //     a = Integer.parseInt(nodes[0]);
            //     b = Integer.parseInt(nodes[1]);

            //     // try {
            //     if (a != b) {
            //         graph[a][b] = 1;
            //         graph[b][a] = 1;
            //     }

            //     // } catch (Exception e) {
            //     // System.out.println("A " + a + "  b = " + b);
            //     // }

            // }
            // // System.out.println(Arrays.deepToString(graph));
            // // for (int[] each : graph) {
            // //     for (int each2 : each) {
            // //         System.out.print(each2 + " ");
            // //     }
            // //     System.out.println();
            // // }
            // // System.out.println(Arrays.toString(line));
            // // for (int[] each : graph) {
            // //     arrlist.clear();
            // //     for (int each2 : each) {
            // //         if (each2 == 1) {
            // //             // System.out.println("each 2"+each2);
            // //             arrlist.add(line[each2]);
            // //             // hmap.put()
            // //             // arrlist.put(line[]);
            // //         }
            // //         hmap.put(line[each[0]], arrlist);
            // //     }
            // //     System.out.println("arrlist " + arrlist);

            // //     System.out.println();
            // // }

            // for (int i = 0; i < v; i++) {
            //     arrlist = new ArrayList<String>();
            //     for (int j = 0; j < v; j++) {
            //         if (graph[i][j] == 1) {
            //             // System.out.println("adding ="+line[j]);
            //             arrlist.add(line[j]);
            //         }
            //     }
            //     hmap.put(line[i], arrlist);
            //     // System.out.println("========== line[i] ="+line[i]);
            //     // System.out.println("aaray list ="+arrlist);
            //     // System.out.println(line[i] + ":" + hmap.get(line[i]));
            //     System.out.println(hmap+"\n");

            // }
            // // System.out.println("etst " + line[5] + ":" + hmap.get(line[5]));
            // // System.out.println("etst " + line[6] + ":" + hmap.get(line[6]));
            // // System.out.println("etst " + line[7] + ":" + hmap.get(line[7]));

            // // System.out.println("________________________________-");
            // if (v == 1) {
            //     System.out.println(v + " vertices, " + (e1 - 1) + " edges");

            // } else {
            //     System.out.println(v + " vertices, " + e1 + " edges");

            // }
            // if (v <= 1) {
            //     System.out.println("No edges");
            // }
            // // for (int i = 0; i < v; i++) {
            // //     // System.out.println(line[i]);
            // //     System.out.println(line[i] + ":" + hmap.get(line[i]));

            // // }
            // // Set s = hmap.keySet();
            // // for (String name : hmap.keySet()) {

            // //     String key = name.toString();
            // //     String value = hmap.get(name).toString();
            // //     System.out.println(key + " " + value);
            // // }
            // // System.out.println("Bihar  " + hmap.get("Bihar"));
            // List<String> list = new ArrayList<String>(hmap.keySet());
            // Set<String> keySet = hmap.keySet();
            // // keySet = hmap.keySet();
            // ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
            // // System.out.println(listOfKeys);
            // Collections.sort(listOfKeys);

            // // System.out.println(listOfKeys);
            // // System.out.println(hmap);
            // for(String name :listOfKeys ){
            //     // System.out.println(name+":"+ hmap.get(name));
            //     System.out.println(name+":"+ hmap.get(name).toString());
            // }

        } else if (type.equals("Matrix")) {
            v = 0;
            e1 = 0;
            v = Integer.parseInt(sc.nextLine());
            e1 = Integer.parseInt(sc.nextLine());
            // System.out.println("e =" + e1);

            String[] line = sc.nextLine().split(",");
            int[][] graph = new int[v][v];

            // System.out.println(Arrays.deepToString(graph));
            int a, b;
            while (sc.hasNext()) {
                nodes = sc.nextLine().split(" ");
                a = Integer.parseInt(nodes[0]);
                b = Integer.parseInt(nodes[1]);
                if (a != b) {
                    graph[a][b] = 1;
                    graph[b][a] = 1;
                }
                if(a==b){
                    e1--;
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
