package Silver;

import java.util.Scanner;

public class BOJ_18511 {

	static int M, K;
	static long num;
	static int[] arr;
	static Integer[] input;
	static long ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		M = N.length();
		num = Long.parseLong(N);
		K = sc.nextInt();

		input = new Integer[K];
		arr = new int[M];
		ans = 0;
		
		for (int i = 0; i < K; i++) {
			input[i] = sc.nextInt();
		}

		
		permutation(0);

		M -= 1;
		arr = new int[M];
		permutation(0);

		System.out.println(ans);

	}

	public static void permutation(int n) {
		if (n == M) {
			String str = "";

			for (int i = 0; i < M; i++) {
				str = str + Integer.toString(arr[i]);
			}

			Long temp = Long.valueOf(str);
			if (num >= temp) {
				if (ans < temp) {
					ans = temp;
				}
			}
			return;
		}

		for (int i = 0; i < K; i++) {
			arr[n] = (int) input[i];
			permutation(n + 1);
		}

	}
}
