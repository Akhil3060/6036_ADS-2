// import java.util.import java.util.ArrayList;
// import java.util.ArrayList;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


// import java.io.*;

public class Solution {

    // Don't modify this method.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                for (String each : t9.getAllWords(prefix)) {
                    System.out.println(each);
                }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            // t9.getSuggestions(bag, k);
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }

            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }

    // Don't modify this method.
    public static String[] toReadFile(String file) {
        In in = new In(file);
        return in.readAllStrings();
    }

    public static BinarySearchST<String, Integer> loadDictionary(String file) {
        BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
        Scanner sc = new Scanner(System.in);
        // System.out.println(toReadFile(file).length);
        // System.out.println(Arrays.toString(toReadFile(file)));
        String[] wordlist = toReadFile(file);
        for (String each : wordlist) {
            each = each.toLowerCase();
            if (st.contains(each)) {
                int val = st.get(each);
                st.put(each, val + 1);
            } else {
                st.put(each, 1);
            }
        }
        return st;
    }

}

class T9 {
    TST tt = new TST();
    public T9(BinarySearchST<String, Integer> st) {
        // String[] wordlist = toReadFile(file);
        // System.out.println(st);


        for (String str : st.keys()) {
            tt.put(str, st.get(str));
            // System.out.println(str);
        }
        // System.out.println(st.keys());
        // while()
        // your code goes here
    }

    // get all the prefixes that match with given prefix.
    public Iterable<String> getAllWords(String prefix) {

        // your code goes here
        return tt.keysWithPrefix(prefix);
    }

    public Iterable<String> potentialWords(String t9Signature) {
        HashMap<Integer, String[]> hp = new HashMap<>();

        // ArrayList<String> l2 =
        //     new ArrayList<String>(Arrays.asList("a", "b", "c"));

        // ArrayList<String> l3 =
        //     new ArrayList<String>(Arrays.asList("d", "e", "f"));

        // ArrayList<String> l4 =
        //     new ArrayList<String>(Arrays.asList("g", "h", "i"));

        // ArrayList<String> l5 =
        //     new ArrayList<String>(Arrays.asList("j", "k", "l"));

        // ArrayList<String> l6 =
        //     new ArrayList<String>(Arrays.asList("m", "m", "o"));

        // ArrayList<String> l7 =
        //     new ArrayList<String>(Arrays.asList("p", "q", "r" , "s"));

        // ArrayList<String> l8 =
        //     new ArrayList<String>(Arrays.asList("t", "u", "v"));

        // ArrayList<String> l9 =
        //     new ArrayList<String>(Arrays.asList("w", "x", "y" , "z"));




        String[] arr2 = {"a", "b", "c"};
        String[] arr3 = {"d", "e", "f"};
        String[] arr4 = {"g", "h", "i"};
        String[] arr5 = {"j", "k", "l"};
        String[] arr6 = {"m", "m", "o"};
        String[] arr7 = {"p", "q", "r" , "s"};
        String[] arr8 = {"t", "u", "v"};
        String[] arr9 = {"w", "x", "y" , "z"};


        // final int one=1,two=2
        hp.put(0 + 2, arr2);
        hp.put(0 + 3, arr3);
        hp.put(0 + 4, arr4);
        hp.put(0 + 5, arr5);
        hp.put(0 + 6, arr6);
        hp.put(0 + 7, arr7);
        hp.put(0 + 8, arr8);
        hp.put(0 + 9, arr9);

        String[] query = t9Signature.split("");
        System.out.println(Arrays.toString(query));
        TrieST tst = new TrieST();

        System.out.println(t9Signature);


        // ArrayList<String> l9 =
        //     new ArrayList<String>(Arrays.asList("a", "b", "c"));
        // System.out.println(l1);
        // your code goes here
        return null;
    }

    // return all possibilities(words), find top k with highest frequency.

    /**
     * Gets the suggestions.
     *
     * @param      words  The words
     * @param      k      { parameter_description }
     *
     * @return     The suggestions.
     */
    public Iterable<String> getSuggestions(final Iterable<String> words, final int k) {
        HashMap<Integer, String> hp = new HashMap<>();
        String[] temp1 = new String[k];
        // int j = 0;
        MaxPQ mp = new MaxPQ();
        for (String each : words) {
            int counter = 0;
            for (Object i : tt.keysWithPrefix(each)) {
                counter++;
            }
            mp.insert(counter);
            hp.put(counter, each);
        }
        int c = 0;
        for (Object qq : mp) {
            if (c == k) {
                break;
            } else {

                // System.out.println(hp.get(qq));
                temp1[c] = hp.get(qq);
                c++;
            }
            // System.out.println(qq);
        }
        Arrays.sort(temp1);
        // for (String s : temp1) {
        //     System.out.println(s);
        // }
        // for(String str:hp){

        // }
        // System.out.println(mp.max());
        // for (int kk : hp.values()) {
        //     System.out.print(kk + ",");
        // }
        // System.out.println();

        // Map<String, Integer> treeMap = new TreeMap<String, Integer>(hp);
        // for (int kk : treeMap.values()) {
        //     System.out.print(kk + ",");
        // }

        // System.out.println(hp.values());
        // System.out.println(k);
        // your code goes here
        Iterable<String> iterable = Arrays.asList(temp1);
        return iterable;
    }

    // final output
    // Don't modify this method.


    /**
     * t9Signature.
     *
     * @param      t9Signature  The t 9 signature
     * @param      k            { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> t9(final String t9Signature, final  int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
