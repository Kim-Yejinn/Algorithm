import java.util.Arrays;
import java.util.Scanner;

public class SWEA_7333_한솔이의택배아르바이트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			int count = 0;
			int[] cnt = new int[52];

			for (int j = 0; j < N; j++) {

				int temp = sc.nextInt();

				if (temp >= 50) {
					N--;
					count++;
				} else {
					if ((50 % temp) == 0) {
						cnt[50 / temp]++;
					} else {
						cnt[50 / temp + 1]++;
					}
				}
			}

			for (int j = 0; j <= 50; j++) {
				if (cnt[j] > 0) {
					N -= j;
					cnt[j]--;
					count++;
				}
				if (N == 0) {
					break;
				} else if (N < 0) {
					count--;
					cnt[j]--;
					N+=j;

				}
				if (cnt[j] != 0) {
					j--;
				}
				System.out.println(count);
				System.out.println(Arrays.toString(cnt));
			}

			System.out.printf("#%d %d\n", i, count);
		}
	}
}
