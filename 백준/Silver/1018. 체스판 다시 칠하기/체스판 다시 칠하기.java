import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = sc.nextInt();

		char[][] arr = new char[N][M];

		for (int r = 0; r < N; r++) {
			String temp = sc.next();
			for (int c = 0; c < M; c++) {
				arr[r][c] = temp.charAt(c);
			}
		}

		int cnt = 64;

		for (int t = 0; t < N - 7; t++) {
			for (int u = 0; u < M - 7; u++) {
				int cnt_b = 0;
				int cnt_w = 0;

				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						if ((c + r + u + t) % 2 == 0) {
							if (arr[r + t][c + u] != 'B') {
								cnt_b++;
							}
							if (arr[r + t][c + u] != 'W') {
								cnt_w++;
							}
						} else {
							if (arr[r + t][c + u] != 'W') {
								cnt_b++;
							}
							if (arr[r + t][c + u] != 'B') {
								cnt_w++;
							}
						}
					}
				}
				if (cnt_b < cnt) {
					cnt = cnt_b;
				}
				if (cnt_w < cnt) {
					cnt = cnt_w;
				}
			}
		}
		System.out.println(cnt);
	}
}
