import java.util.Scanner;

public class BOJ_2559 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[K];
		int cnt = 0;
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			if (cnt == K) {
				cnt = 0;
			}
			arr[cnt] = temp;
			int sum = 0;
			for (int j = 0; j < K; j++) {
				sum += arr[j];
			}
			if (sum > result && i >= K - 1) {
				result = sum;
			}
			cnt++;
		}
		System.out.println(result);
	}
}
