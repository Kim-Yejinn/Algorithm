package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_15657 {
	static int N, M;
	static int[] arr;
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		arr = new int[M];
		input = new int[N];

		String[] str1 = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(str1[i]);
		}

		Arrays.sort(input);
		combination(0, 0);
		bw.flush();
	}

	public static void combination(int num, int start) throws IOException {
		if (num == M) {
			for (int i = 0; i < M; i++) {
				sb.append(input[arr[i]]).append(" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = start; i < N; i++) {
			arr[num] = i;
			combination(num + 1, i);
		}
	}
}
