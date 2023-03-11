package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(tk.nextToken());
			if (map.containsKey(t)) {
				map.put(t, map.get(t) + 1);
			} else {
				map.put(t, 1);
			}
		}

		int M = Integer.parseInt(br.readLine());
		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int t = Integer.parseInt(tk.nextToken());
			if (map.containsKey(t)) {
				bw.write(map.get(t) + " ");
			} else {
				bw.write("0 ");
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
