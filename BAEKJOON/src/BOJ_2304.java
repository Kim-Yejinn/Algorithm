import java.util.Scanner;

public class BOJ_2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[1001];

		int max_idx = 0;
		int min_idx = 1010;

		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();

			arr[L] = H;

			if (max_idx < L) {
				max_idx = L;
			}
			if (min_idx > L) {
				min_idx = L;
			}
		}


		int cnt = 0;

		int curr_left = 0;
		int curr_right = 0;
		for (int i = 0; i <= (max_idx - min_idx) / 2; i++) {

			if (curr_left < arr[min_idx + i]) {
				curr_left = arr[min_idx + i];
			}
			if (curr_right < arr[max_idx - i]) {
				curr_right = arr[max_idx - i];
			}
			cnt += curr_left + curr_right;
		}
		System.out.println(cnt);
	}
}
