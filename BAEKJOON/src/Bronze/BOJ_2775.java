package Bronze;

import java.util.Scanner;

public class BOJ_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int k = sc.nextInt();
			int n = sc.nextInt();

			int[][] arr = new int[k + 1][n + 1];

			for (int j = 0; j <= k; j++) {
				if (j == 0) {
					for (int q = 1; q <= n; q++) {
						arr[0][q] = q;
					}
				} else {
					int tempsum = 0;
					for (int q = 1; q <= n; q++) {
						tempsum += arr[j - 1][q];
						arr[j][q] = tempsum;
					}
				}
			}
			System.out.println(arr[k][n]);
		}
	}
}
