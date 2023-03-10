package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ_15663 {
	static int N, M;
	static int[] arr;
	static int[] c;
	static List<Integer> input = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		arr = new int[M];

		String[] str1 = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(str1[i]);
			if (input.size() == 0) {
				input.add(temp);
			}

			for (int j = 0; j < input.size(); j++) {
				if (input.get(j) == temp) {
					break;
				}
				if (j == input.size() - 1) {
					input.add(temp);
				}
			}

		}
		N = input.size();
		c = new int[N + 1];
		Collections.sort(input);
		combination(0);
		bw.flush();
	}

	public static void combination(int num) throws IOException {

		if (num == M) {
			for (int i = 0; i < M; i++) {
				sb.append(input.get(arr[i])).append(" ");
			}
			sb.append("\n");
			bw.write(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (c[i] != 1) {
				arr[num] = i;
				c[i] = 1;
				combination(num + 1);
				c[i] = 0;
			}
		}
	}
}
