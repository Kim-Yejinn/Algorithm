import java.util.Scanner;

public class SWEA_7272_안경이없어 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			String a = sc.next();
			String b = sc.next();

			if (a.length() != b.length()) {
				System.out.printf("#%d %s\n", i, "DIFF");
			} else {
				for (int j = 0; j < a.length(); j++) {
					if (change(a.charAt(j)) != change(b.charAt(j))) {
						System.out.printf("#%d %s\n", i, "DIFF");
						break;
					}
					if (j == a.length() - 1) {
						System.out.printf("#%d %s\n", i, "SAME");
					}
				}

			}

		}

	}

	public static int change(char c) {

		if (c == 'B')
			return 1;
		else if (c == 'A' || c == 'D' || c == 'O' || c == 'P' || c == 'Q' || c == 'R')
			return 2;
		else
			return 3;
	}
}
