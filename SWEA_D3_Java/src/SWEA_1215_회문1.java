import java.util.Scanner;

public class SWEA_1215_회문1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int N = sc.nextInt();

			char[][] arr = new char[8][8];

			int cnt = 0;

			for (int r = 0; r < 8; r++) {
				String in = sc.next();
				for (int c = 0; c < 8; c++) {
					arr[r][c] = in.charAt(c);
				}
			}

			for (int r = 0; r < 8; r++) {
				for (int a = 0; a < 9 - N; a++) {
					char[] temp1 = new char[N];
					char[] temp2 = new char[N];

					for (int b = 0; b < N; b++) {
						temp1[b] = arr[r][a + b];
						temp2[b] = arr[a + b][r];
					}

					int flag1 = 1;
					int flag2 = 1;

					for (int j = 0; j < N / 2; j++) {
						if (temp1[j] != temp1[N - 1 - j]) {
							flag1 = 0;
							break;
						}
					}
					if (flag1 == 1) {
						cnt++;
					}

					for (int j = 0; j < N / 2; j++) {
						if (temp2[j] != temp2[N - 1 - j]) {
							flag2 = 0;
							break;
						}
					}
					if (flag2 == 1) {
						cnt++;
					}

				}
			}
			System.out.printf("#%d %d\n",i,cnt);
		}
	}
}
