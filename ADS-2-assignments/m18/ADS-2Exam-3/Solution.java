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
            t9.getSuggestions(bag, k);
            // for (String each : t9.getSuggestions(bag, k)) {
            //     System.out.println(each);
            // }

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
        // your code goes here
        return null;
    }

    // return all possibilities(words), find top k with highest frequency.
    public Iterable<String> getSuggestions(Iterable<String> words, int k) {
        HashMap<Integer,String> hp = new HashMap<>();
        int[] temp = new int[6];
        String[] temp1 = new String[k];
        int j = 0;
        MaxPQ mp = new MaxPQ();
        for (String each : words) {
            // System.out.println(tt.get(each));
            // System.out.println(each+" - "+tt.keysWithPrefix(each));
            // String[] newWords = tt.keysWithPrefix(each);
            int counter = 0;
            for (Object i : tt.keysWithPrefix(each)) {
                counter++;
            }

            mp.insert(counter);
            hp.put( counter,each);
            temp[j] = counter;
            // temp1[j] = each;
            // Arrays.sort(temp);
            // System.out.println(hp);
            // System.out.println(counter);
            // System.out.println( tt.keysWithPrefix(each));
        }
        int c=0;
        for(Object qq : mp){
            if(c==k){
                break;
            }
            else{

                // System.out.println(hp.get(qq));
                temp1[c] = hp.get(qq);
                c++;
            }
            // System.out.println(qq);
        }
        Arrays.sort(temp1);
        for(String s:temp1){
            System.out.println(s);
        }
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
        return null;
    }

    // final output
    // Don't modify this method.
    public Iterable<String> t9(String t9Signature, int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
