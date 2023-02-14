import java.util.Scanner;

public class SWEA_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int dump = sc.nextInt();

			int[] cnt_temp = new int[101];

			int[] cnt = new int[101];
			int[] cnt_rev = new int[101];

			for (int j = 0; j < 100; j++) {
				int temp = sc.nextInt();
				cnt_temp[temp]++;
				cnt[temp]++;
				cnt_rev[101 - temp]++;
			}

			for (int j = 1; j <= 100; j++) {
				cnt[j] += cnt[j - 1];
				cnt_rev[j] += cnt_rev[j - 1];
			}

			int min = 0, max = 0;
			int r_min = 0, r_max = 100;

			for (int k = 1; k <= 100; k++) {

				min += cnt[k];
				max += cnt_rev[k];

				if (min <= dump) {
					r_min = k + 1;
				}
				if (max <= dump) {
					r_max = 100 - k;
				}
			}
			System.out.printf("#%d %d\n", i, r_max - r_min);

		}

	}
}
