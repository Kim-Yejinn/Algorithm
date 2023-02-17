import java.util.Scanner;

public class SWEA_1983_조교의성적매기기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		String[] score = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] arr = new int[N];
			int temp_score = 0;

			for (int j = 0; j < N; j++) {
				int s1 = sc.nextInt();
				int s2 = sc.nextInt();
				int s3 = sc.nextInt();

				arr[j] = s1 * 35 + s2 * 45 + s3 * 20;
				if (j == K - 1) {
					temp_score = arr[j];
				}
			}
			int cnt = 0;

			for (int k = 0; k < N; k++) {
				if (temp_score < arr[k])
					cnt++;
			}
			
			System.out.printf("#%d %s\n", i, score[cnt/(N/10)]);

		}

	}
}
