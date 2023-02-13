import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int j = 1; j <= T; j++) {
			int N = sc.nextInt();
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				String temp = sc.next();

				for (int c = 0; c < N; c++) {
					int temp2 = temp.charAt(c) - '0';
					int idx = Math.abs(N / 2 - r);

					if (c >= idx && c <= N - 1 - idx) {
						cnt += temp2;
					}
				}
				

			}
			System.out.printf("#%d %d\n",j,cnt);

		}

	}
}
