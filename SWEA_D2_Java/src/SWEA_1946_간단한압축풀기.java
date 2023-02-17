import java.util.Scanner;

public class SWEA_1946_간단한압축풀기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int cnt = 0;

			char[] c = new char[N];
			int[] num = new int[N];
			for (int j = 0; j < N; j++) {
				c[j] = sc.next().charAt(0);
				num[j] = sc.nextInt();
			}
			System.out.println("#"+i);

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < num[j]; k++) {

					System.out.print(c[j]);
					cnt++;
					if (cnt == 10) {
						System.out.println();
						cnt = 0;
					}

				}
			}
			System.out.println();

		}
	}
}
