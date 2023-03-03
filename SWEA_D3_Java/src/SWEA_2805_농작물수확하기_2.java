import java.util.Scanner;

public class SWEA_2805_농작물수확하기_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();

			int sum = 0;
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < N; c++) {
					if (c >= Math.abs(N / 2 - r) && c <= (N - 1 - Math.abs(N / 2 - r))) {
						sum += str.charAt(c) - '0';
					}
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
