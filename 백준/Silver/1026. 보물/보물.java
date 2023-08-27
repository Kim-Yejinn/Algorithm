import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] A = new int[N];
		int[] B = new int[N];
		int[] B1 = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		Arrays.sort(A);

		int idx = 0;
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				if (temp < B[j]) {
					temp = B[j];
					idx = j;
				}
			}
			B1[i] = temp;
			B[idx] = 0;
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i] * B1[i];
		}
		System.out.println(sum);
	}
}