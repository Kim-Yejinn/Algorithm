import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2548 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		int num = 0;
		for (int i = N - 1; i >= 0; i--) {
			int temp = 0;
			for (int j = N - 1; j >= 0; j--) {
				temp += Math.abs(arr[i] - arr[j]);
			}
			if (temp <= min) {
				num = arr[i];
				min = temp;
			}
		}
		System.out.println(num);

	}
}
