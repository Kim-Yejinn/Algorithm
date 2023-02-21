import java.util.Scanner;

public class BOJ_2798 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = sc.nextInt();

		int[] arr = new int[N];

		int sum = 0;
		int min = 300000;
		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					for (int k = 0; k < N; k++) {
						if (i != k && j != k) {
							if (M - (arr[i] + arr[j] + arr[k]) < min && (arr[i] + arr[j] + arr[k]) <= M) {
								min = M - (arr[i] + arr[j] + arr[k]);
								sum = arr[i] + arr[j] + arr[k];
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
}
