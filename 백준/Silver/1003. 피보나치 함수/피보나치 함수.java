
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int one;
	static int zero;
	static int[] memo;
	static int[][] cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			memo = new int[N + 1];
			cnt = new int[N + 1][2];

			fibo(N);
			bw.write(cnt[N][0] + " " + cnt[N][1] + "\n");
		}
		bw.flush();
	}

	public static int fibo(int num) {
		if (num == 1) {
			cnt[num][1] = 1;
			return 1;
		}
		if (num == 0) {
			cnt[num][0] = 1;
			return 0;
		}

		if (memo[num] != 0) {
			cnt[num][0] = cnt[num - 1][0] + cnt[num - 2][0];
			cnt[num][1] = cnt[num - 1][1] + cnt[num - 2][1];
		} else {
			memo[num] = fibo(num - 1) + fibo(num - 2);
			cnt[num][0] = cnt[num - 1][0] + cnt[num - 2][0];
			cnt[num][1] = cnt[num - 1][1] + cnt[num - 2][1];
		}
		return memo[num];

	}
}
