import java.util.Scanner;

public class SWEA_10505_소득불균형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			int[] arr = new int[N];
			int sum = 0;
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}

			for (int j = 0; j < N; j++) {
				if (arr[j] <= sum / N)
					cnt++;
			}
			System.out.printf("#%d %d\n", i, cnt);

		}
	}
}
