import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IM_230227 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();

			int K_MIN = sc.nextInt();
			int K_MAX = sc.nextInt();

			int[] cnt = new int[101];

			int max = 0;
			int min = 100;
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				cnt[temp]++;
				if (max < temp) {
					max = temp;
				}
				if (min > temp) {
					min = temp;
				}
			}

			List<Integer> list = new ArrayList<Integer>();
			for (int j = min; j <= max; j++) {
				if (cnt[j] != 0) {
					list.add(cnt[j]);
				}
			}

			int result_min = 2000;
			for (int a = 1; a <= list.size() - 2; a++) {
				for (int b = 1; b <= list.size() - a - 1; b++) {
					int c = list.size() - a - b;

					int[] sum = new int[3]; // 0:a 1:b 2:c

					for (int q = 0; q < a; q++) {
						sum[0] += list.get(q);
					}
					for (int w = 0; w < b; w++) {
						sum[1] += list.get(a + w);
					}
					for (int e = 0; e < c; e++) {
						sum[2] += list.get(a + b + e);
					}

					if (sum[0] >= K_MIN && sum[0] <= K_MAX && sum[1] >= K_MIN && sum[1] <= K_MAX && sum[2] >= K_MIN
							&& sum[2] <= K_MAX) {
						int temp_min = sum[0];
						int temp_max = sum[0];
						for (int k = 1; k <= 2; k++) {
							if (temp_min > sum[k]) {
								temp_min = sum[k];
							}
							if (temp_max < sum[k]) {
								temp_max = sum[k];
							}
						}
						int temp_diff = temp_max - temp_min;
						if (result_min > temp_diff) {
							result_min = temp_diff;
						}
					}
				}
			}
			if (result_min == 2000) {
				System.out.printf("#%d %d\n", i, -1);
			} else {
				System.out.printf("#%d %d\n", i, result_min);
			}
		}
	}
}
