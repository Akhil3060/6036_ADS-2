import java.util.Scanner;
import java.util.Arrays;
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
	 * Main funtion.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		LSD lsd = new LSD();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] tokens = new String[n];
		//complexity n reads input
		for (int i = 0; i < n; i++) {
			tokens[i] = sc.nextLine();
		} lsd.sort(tokens, tokens[0].length());
		System.out.println(Arrays.toString(tokens));
	}
}




