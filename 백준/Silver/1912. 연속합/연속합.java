
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n + 1];
		int minus = -2000;
		int max = -1;
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();

			if (a < 0 && minus < a) {
				minus = a;
			}

			if (arr[i - 1] < 0) {
				arr[i] = a;
			} else {
				arr[i] = arr[i - 1] + a;
			}

			if (arr[i] > max) {
				max = arr[i];
			}

		}
		if (max >= 0) {
			System.out.println(max);
		} else {
			System.out.println(minus);
		}
	}
}
