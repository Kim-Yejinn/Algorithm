package Silver;

import java.util.Scanner;

public class BOJ_15652 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		combination(0, 1);
	}

	public static void combination(int num, int start) {

		if (num == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[num] = i;
			combination(num + 1, i);
		}
	}
}
