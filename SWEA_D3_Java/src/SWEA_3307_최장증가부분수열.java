import java.util.Scanner;

public class SWEA_3307_최장증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			long[] arr = new long[N];

			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextLong();

			}

			long[] temp = new long[N];

			int cnt = 1;
			temp[0] = arr[0];

			for (int j = 1; j < N; j++) {

				if (arr[j] >= temp[cnt - 1]) {
					temp[cnt] = arr[j];
					cnt++;
				} else {
					for (int k = 0; k < cnt; k++) {
						if (arr[j] < temp[k]) {
							temp[k] = arr[j];
							break;
						}

					}

				}

//				System.out.println(Arrays.toString(temp));
			}
			System.out.printf("#%d %d\n", i, cnt);

		}
	}
}
