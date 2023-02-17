import java.util.Scanner;

public class SWEA_1989_초심자의회문검사_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {

			String input = sc.next();
			boolean check = true;
			for (int j = 0; j < input.length() / 2; j++) {
				if (input.charAt(j) != input.charAt(input.length() - 1 - j)) {
					check = false;
				}
			}
			if (check == true) {
				System.out.printf("#%d %d\n", i, 1);
			} else {
				System.out.printf("#%d %d\n", i, 0);
			}

		}

	}
}
