package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class BOJ_4195 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		int[] parents = new int[200010];
//		for (int i = 0; i < parents.length; i++) {
//			parents[i] = i;
//		}

		int t = 0;

		for (int tc = 0; tc < T; tc++) {
			int F = Integer.parseInt(br.readLine());
			for (int i = 0; i < 2 * F; i++) {
				parents[i] = i;
			}
			Map<String, Integer> map = new HashMap<String, Integer>();

			t = 0;

			for (int i = 0; i < F; i++) {
				String[] str = br.readLine().split(" ");

				map.put(str[0], map.size());

				map.put(str[1], map.size());

				union(parents, map.get(str[0]), map.get(str[1]));
				int cnt = 0;

				for (int k = 0; k < map.size(); k++) {
					if (getParents(parents, k) == getParents(parents, map.get(str[0]))) {
						cnt++;
					}
				}
				bw.write(cnt + "\n");
				t = map.size();
			}
		}
		bw.flush();
		bw.close();

	}

	public static int getParents(int[] parents, int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = getParents(parents, parents[x]);
	}

	public static void union(int[] parents, int a, int b) {
		int aroot = getParents(parents, a);
		int broot = getParents(parents, b);

		if (aroot < broot) {
			parents[broot] = aroot;
		} else {
			parents[aroot] = broot;
		}
	}

}
