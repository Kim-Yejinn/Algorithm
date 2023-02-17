import java.util.Scanner;

public class SWEA_2007_패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			String input = sc.next();
			int min = 11;
			int t = 0;

			for (int j = 10; j >= 1; j--) {
				int c = 30 / j;
				int[][] temp = new int[c][j];

				for (int m = 0; m < c; m++) {
					for (int n = 0; n < j; n++) {
						temp[m][n] = input.charAt(m * j + n);
					}
				}

				for (int m = 0; m < c - 1; m++) {
					for (int n = 0; n < j; n++) {
						if (temp[m][n] == temp[m + 1][n]) {
							t = 1;
						} else {
							t = 0;
						}
					}
				}
				if (t == 1) {
					if (min > j)
						min = j;
				}

			}

			System.out.printf("#%d %d\n", i, min);
		}
	}
}
