
import java.util.Arrays;
import java.util.Scanner;

public class Main {
//dp
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N + 1];
		arr[0] = 0;
		arr[1] = 1;
		if (N > 2) {
			arr[3] = 1;
		}
		if (N > 4) {
			arr[5] = 1;
		}
		for (int i = 6; i <= N; i++) {
			if (arr[i] == 0 || arr[i] > arr[i - 3] + 1) {
				if (arr[i - 3] > 0) {
					arr[i] = arr[i - 3] + 1;
				}
			}
			if (arr[i] == 0 || arr[i] > arr[i - 5] + 1) {
				if (arr[i - 5] > 0) {
					arr[i] = arr[i - 5] + 1;
				}
			}
		}
		if (arr[N] == 0) {
			System.out.println(-1);
		} else {

			System.out.println(arr[N]);
		}
	}
}
