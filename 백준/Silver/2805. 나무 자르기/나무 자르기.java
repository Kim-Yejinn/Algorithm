import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		long M = Long.parseLong(tk.nextToken());

		arr = new long[N];

		long max = 0;
		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(tk.nextToken());
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		long left = 0;
		long right = max;
		long mid = 0;

		long result = 0;
		while (left <= right) {
			mid = (left + right) / 2;
//			if (mid == 0) {
//				mid = 1;
//			}
			long temp = cut(mid);

			if (temp == M) {
				result = mid;
				break;
			}
			if (temp > M) {
				left = mid + 1;
				result = mid;
			}
			if (temp < M) {
				right = mid - 1;
			}
		}
		bw.write(result + "");
		bw.flush();
	}

	public static long cut(long num) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] - num > 0) {
				sum += (arr[i] - num);
			}
		}
		return sum;
	}
}