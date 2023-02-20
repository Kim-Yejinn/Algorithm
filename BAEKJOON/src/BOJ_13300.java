import java.util.Scanner;

public class BOJ_13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생수
		int K = sc.nextInt(); // 최대인원

		int[] M = new int[7];
		int[] W = new int[7];

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int S = sc.nextInt(); // 성별
			int Y = sc.nextInt(); // 학년

			if (S == 0) {// 여
				W[Y]++;
			} else {// 남
				M[Y]++;
			}
		}

		for (int i = 1; i < 7; i++) {
			while (W[i] > 0) {
				W[i] -= K;
				cnt++;
			}
			while (M[i] > 0) {
				M[i] -= K;
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
