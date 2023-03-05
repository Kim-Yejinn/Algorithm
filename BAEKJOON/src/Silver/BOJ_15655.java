package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655 {
	static int N, M;
	static int[] arr;
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);
		combination(0, 0);

	}

	public static void combination(int num, int start) {
		if (num == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(input[arr[i]] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			arr[num] = i;
			combination(num + 1, i + 1);
		}

	}
}
