import java.util.Scanner;

public class SWEA_1860_진기의최고급붕어빵_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		s: for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 사람수
			int M = sc.nextInt(); // 만드는 시간
			int K = sc.nextInt(); // 붕어빵 개수

			int[] arr = new int[11113];

			for (int i = M; i < arr.length; i += M) {
				arr[i] = K;
			}

			int[] cnt = new int[11112];

			for (int i = 0; i < N; i++) {
				cnt[sc.nextInt()] += 1;
			}

			for (int i = 0; i < cnt.length; i++) {
				if (arr[i] - cnt[i] < 0) {
					System.out.printf("#%d %s\n", tc, "Impossible");
					continue s;
				} else {
					arr[i] -= cnt[i];
					if (arr[i] > 0) {
						arr[i + 1] += arr[i];
					}
				}
			}
			System.out.printf("#%d %s\n", tc, "Possible");

		}

	}
}
