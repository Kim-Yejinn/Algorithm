package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
	static int M, N;
	static int[] arr;
	static int[] input;
	static int[] c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		c = new int[N];
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);
		permutation(0);
	}

	public static void permutation(int num) {
		if (num == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(input[arr[i]] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (c[i] == 0) {
				c[i] = 1;
				arr[num] = i;
				permutation(num + 1);
				c[i] = 0;
			}

		}

	}
}
