import java.util.Scanner;

public class BOJ_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			String in = sc.next();
			int cnt_O = 0;
			int score = 0;
			for (int j = 0; j < in.length(); j++) {
				char temp = in.charAt(j);

				if (temp == 'O') {
					cnt_O++;
					score += cnt_O;
				} else if (temp == 'X') {
					cnt_O = 0;
				}

			}
			System.out.println(score);
			score = 0;
		}
	}
}
