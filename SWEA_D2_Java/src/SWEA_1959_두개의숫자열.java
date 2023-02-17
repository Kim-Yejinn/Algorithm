import java.util.Scanner;

public class SWEA_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] a = new int[N];
			int[] b = new int[M];

			int max = 0;

			for (int j = 0; j < N; j++) {
				a[j] = sc.nextInt();
			}
			for (int k = 0; k < M; k++) {
				b[k] = sc.nextInt();
			}

			int temp = Math.abs(M - N);

			if (M > N) {

				for (int m = 0; m <= temp; m++) {
					int t = 0;
					for (int n = 0; n < N; n++) {
						t += a[n] * b[n + m];

					}

					if (t > max)
						max = t;
				}

			} else if (M < N) {
				for (int m = 0; m <= temp; m++) {
					int t = 0;
					for (int n = 0; n < M; n++) {
						t += a[n + m] * b[n];

					}
					if (t > max)
						max = t;
				}

			} else {
				int t = 0;
				for (int n = 0; n < N; n++) {
					t += a[n] * b[n];

				}
				if (t > max)
					max = t;
			}

			System.out.printf("#%d %d\n",i,max);

		}

	}
}
