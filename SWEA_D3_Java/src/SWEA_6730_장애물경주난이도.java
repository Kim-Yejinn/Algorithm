import java.util.Scanner;

public class SWEA_6730_장애물경주난이도 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();

			int[] arr = new int[N];
			int rise = 0;
			int fall = 0;

			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				int temp = 0;
				if (j != 0)
					temp = arr[j] - arr[j - 1];

				if (temp >= 0) {
					if (rise < temp)
						rise = temp;
				} else {
					if (fall < Math.abs(temp)) {
						fall = Math.abs(temp);
					}

				}

			}

			System.out.printf("#%d %d %d\n", i, rise, fall);

		}

	}
}
