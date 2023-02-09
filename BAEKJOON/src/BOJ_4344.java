import java.util.Scanner;

public class BOJ_4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();

		for (int i = 0; i < C; i++) {

			int N = sc.nextInt();

			int[] arr = new int[N];
			int sum = 0;
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (arr[j] > sum / N) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n", cnt * 100.0 / N);
		}
	}
}
