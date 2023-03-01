import java.util.Scanner;

public class BOJ_2304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[1001];

		int max_idx = 0;
		int min_idx = 1010;
		int max_value = 0;
		int max_value_idx = 0;
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
			if (max_value < H) {
				max_value = H;
				max_value_idx = L;
			}
		}

		int curr_max = 0;
		int sum = 0;
		for (int i = min_idx; i <= max_value_idx; i++) {
			if (curr_max < arr[i]) {
				curr_max = arr[i];
			}
			sum += curr_max;
		}
		curr_max = 0;
		for (int i = max_idx; i > max_value_idx; i--) {
			if (curr_max < arr[i]) {
				curr_max = arr[i];
			}
			sum += curr_max;
		}

		System.out.println(sum);
	}
}
