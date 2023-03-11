package Bronze;

import java.util.Scanner;

public class BOJ_10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			int s = N % H;
			int n = 0;
			if (s == 0) {
				s = H;
				n = N / H;
			} else {
				n = N / H + 1;
			}
			System.out.println(s * 100 + n);
		}

	}
}
