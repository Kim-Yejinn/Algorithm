import java.util.Scanner;

public class SWEA_1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		char[] buffer;

		out: for (int i = 1; i <= T; i++) {
			String input = sc.next();

			buffer = input.toCharArray();
			int len = input.length();

			for (int j = 0; j < len / 2; j++) {
				if (buffer[j] == buffer[len - j - 1]) {
					System.out.printf("#%d 1\n", i);
					continue out;
				}
			}
			System.out.printf("#%d 0\n", i);

		}
	}
}
