import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		if (N < 3) {
			if (N == 2) {
				if (arr[0] == arr[1]) {
					System.out.println(arr[1]);
					return;
				}

			}
			System.out.println("A");
		} else {
			if (arr[1] == arr[0] && arr[1] != arr[2]) {
				System.out.println("B");
				return;
			}
			double A;
			double B;
			if (arr[1] == arr[0] && arr[1] == arr[2]) {
				A = 1;
				B = 0;
			} else {
				A = (arr[2] - arr[1]) * 1.0 / (arr[1] - arr[0]);
				int a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
				B = arr[2] - (A * arr[1]);
				int b = (int) (arr[2] - (A * arr[1]));

				if (A != a || B != b) {
					System.out.println("B");
					return;
				}
			}

			for (int i = 3; i < N; i++) {
				if (arr[i] != (A * arr[i - 1] + B)) {
					System.out.println("B");
					return;
				}
			}

			System.out.println((int) (arr[N - 1] * A + B));

		}

	}
}
