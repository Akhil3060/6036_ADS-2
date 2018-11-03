import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;



class PageRank {
    PageRank() {

    }

    void putPR() {

    }
    // double getPR(int v) {

    // }
    // String toString() {

    // }

}

class WebSearch {
    WebSearch(PageRank rk, String name) {

    }

}


public class Solution {

    public static void main(String[] args) {
        // read the first line of the input to get the number of vertices

        // iterate count of vertices times
        // to read the adjacency list from std input
        // and build the graph


        // Create page rank object and pass the graph object to the constructor

        // print the page rank object

        // This part is only for the final test case

        // File path to the web content
        String file = "WebContent.txt";

        // instantiate web search object
        // and pass the page rank object and the file path to the constructor
        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky

        HashMap<Integer, Integer> mpin = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> mpinList = new HashMap<>();
        HashMap<Integer, Integer> mpout = new HashMap<>();
        HashMap<Integer, Double> curPR = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int v = Integer.parseInt(sc.nextLine());
        int[][] graph = new int[v][v];
        int a, b;
        int c = v;
        int count = 0;
        int e = 0;
        ArrayList<Integer> li = new ArrayList<>();
        while (v > 0) {
            li = new ArrayList<>();
            v--;
            a = 0;
            b = 0;
            String[] line = sc.nextLine().split(" ");
            a = Integer.parseInt(line[0]);
            mpout.put(a, line.length - 1);
            curPR.put(a, 0.25);
            for (int i = 1; i < line.length; i++) {
                b = Integer.parseInt(line[i]);
                if(a!=b) graph[a][b] = 1;
                e++;
                li = mpinList.get(b);
                // try {
                //     li = mpinList.get(b);
                // } catch (Exception g) {
                //     // li = new ArrayList<>();
                //     li.add(a);
                //     mpinList.put(b, li);
                // }
                if (li == null) {
                    ArrayList<Integer> li1 = new ArrayList<>();
                    li1.add(a);
                    mpinList.put(b, li1);
                } else {
                    li.add(a);
                    mpinList.put(b, li);
                }
                // li = mpinList.get(b);





                try {
                    count = mpin.get(b);

                } catch (Exception f) {
                    mpin.put(b, 1);
                    // li.add(b);
                    // mpinList.put(b, li);
                    continue;
                }
                // li.add(b);
                // mpinList.put(b, li);
                mpin.put(b, count + 1);
            }
        }

        // System.out.println(mpin);
        // System.out.println(mpout);
        // System.out.println(mpinList);
        // System.out.println(curPR);
        System.out.println(c + " vertices, " + e + " edges ");
        // System.out.println(Arrays.deepToString(graph));
        for (int i = 0; i < c; i++) {
            // System.out.println("test 1");
            System.out.print(i + ": ");
            for (int j = c - 1; j >= 0; j--) {
                // System.out.println("test 2");
                if (graph[i][j] == 1) {
                    System.out.print( j + " ");
                }
            }
            System.out.println();
        }


//         for (int i = 0; i < c; i++) {
//             Double val = 0.0;
//             for (int j = 0; j < 10; j++) {
//                 val = 0.0;
//                 try {
//                     for (int each : mpinList.get(i)) {
//                         val  += (curPR.get(each) ) / (mpout.get(each));
//                     }
//                     curPR.put(i, val);
//                 } catch (Exception h) {
//                     // System.out.println(i);
//                     curPR.put(i, 0.0);
//                 }

//                 System.out.println("Iter =" + i + "-" + curPR);
// //
//             }
//             System.out.println();
//         }
            Double val = 0.0;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < c; i++) {
                val = 0.0;
                try {
                    for (int each : mpinList.get(i)) {
                        val  += (curPR.get(each) ) / (mpout.get(each));
                    }
                    curPR.put(i, val);
                } catch (Exception h) {
                    // System.out.println(i);
                    curPR.put(i, 0.0);
                }

                // System.out.println("Iter =" + j + "-" + curPR);
            }
            // System.out.println();
        }
        System.out.println();

        // System.out.println(curPR);

        for(int k : curPR.keySet()){
            System.out.println(k+" - "+curPR.get(k));
        }
    }

}
