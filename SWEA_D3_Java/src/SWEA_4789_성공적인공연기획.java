import java.util.Scanner;

public class SWEA_4789_성공적인공연기획 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			String input = sc.next();

			int cnt = 0;
			int sum = 0;

			for (int j = 0; j < input.length(); j++) {
				int temp = input.charAt(j) - '0';
				if (j > sum) {
					cnt += j - sum;
					sum = j;
				}

				sum += temp;

			}
			System.out.printf("#%d %d\n", i, cnt);

		}

	}
}
