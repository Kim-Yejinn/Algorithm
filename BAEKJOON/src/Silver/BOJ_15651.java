package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15651 {
	// 중복조합문제
	static int N, M;
	static int[] arr;

	static StringBuilder sb = new StringBuilder();

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = str[0].charAt(0) - '0';
		M = str[1].charAt(0) - '0';

		arr = new int[M];

		combination(0);
		bw.flush();

	}

	public static void combination(int num) throws IOException {
		if (num == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[num] = i;
			combination(num + 1);
		}

	}
}
