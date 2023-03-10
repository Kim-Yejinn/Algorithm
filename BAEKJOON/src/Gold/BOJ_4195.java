package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class BOJ_4195 {

	public static int[] parents;
	public static int[] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		parents = new int[200010];
		count = new int[200010];
		for (int tc = 0; tc < T; tc++) {
			int F = Integer.parseInt(br.readLine());
			for (int i = 0; i < 2 * F; i++) {
				parents[i] = i;
				count[i] = 1;
			}
			Map<String, Integer> map = new HashMap<String, Integer>();

			for (int i = 0; i < F; i++) {
				String[] str = br.readLine().split(" ");

				if (!map.containsKey(str[0])) {
					map.put(str[0], map.size());
				}
				if (!map.containsKey(str[1])) {
					map.put(str[1], map.size());
				}

				bw.write(union(map.get(str[0]), map.get(str[1])) + "\n");
			}
		}
		bw.flush();
		bw.close();

	}

	// path compression
	public static int getParents(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = getParents(parents[x]);
	}

	public static int union(int a, int b) {
		int aroot = getParents(a);
		int broot = getParents(b);

		if (aroot == broot) {
			return count[aroot];
		}
		if (aroot < broot) {
			parents[broot] = aroot;
			count[aroot] += count[broot];
			return count[aroot];
		} else {
			parents[aroot] = broot;
			count[broot] += count[aroot];
			return count[broot];
		}

	}

}
