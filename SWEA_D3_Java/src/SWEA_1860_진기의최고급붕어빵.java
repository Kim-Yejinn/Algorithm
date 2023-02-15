import java.util.Scanner;

public class SWEA_1860_진기의최고급붕어빵 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt(); // 사람수
			int M = sc.nextInt(); // 시간
			int K = sc.nextInt(); // 붕어빵

			int[] cnt = new int[11112];
			int temp = 1;

			while (M * temp <= 11111) {
				cnt[M * temp] += K;
				temp++;
			}
			for (int j = 0; j < N; j++) {
				cnt[sc.nextInt()]--;
			}

			for (int k = 0; k <= 11111; k++) {
				if (cnt[k] < 0) {
					System.out.printf("#%d %s\n", i, "Impossible");
					break;
				} else if (k == 11111) {
					System.out.printf("#%d %s\n", i, "Possible");

				}

				if (cnt[k] >= 1 && k < 11111)
					cnt[k + 1] += cnt[k];

			}

		}

	}
}
