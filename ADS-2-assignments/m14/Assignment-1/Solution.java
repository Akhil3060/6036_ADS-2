import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String[] wordList = loadwordLists();
        //Your code goes here...
        TST tst = new TST();
        for (int i = 0; i < wordList.length; i++) {
            int n = wordList[i].length();
            String[] suffixes = new String[n];
            for (int j = 0; j < n; j++) {
                suffixes[j] = wordList[i].substring(j, n);
                tst.put(suffixes[j], 0);

            }

        }
        Scanner sc = new Scanner(System.in);
        Iterable<String> st = tst.keysWithPrefix(sc.nextLine());

        for (String s : st) {
            System.out.println(s.toString());
        }
    }
    /**
     * Load words from file.
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] loadwordLists() {
        In in = new In("/Files/dictionary-algs4.txt");
        String[] wordLists = in.readAllStrings();
        return wordLists;
    }
}


