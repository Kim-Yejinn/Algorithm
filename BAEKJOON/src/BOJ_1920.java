import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int M = sc.nextInt();
		for (int j = 0; j < M; j++) {

			int temp = sc.nextInt();
			int start = 0;
			int end = arr.length - 1;
			boolean flag = false;
			while (start <= end) {

				int mid = (start + end) / 2;

				if (arr[mid] == temp) {
					System.out.println(1);
					flag = true;
					break;
				} else if (arr[mid] < temp) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			if (flag == false) {
				System.out.println(0);
			}

		}

	}
}
