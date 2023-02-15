import java.util.Scanner;

public class SWEA_6485_삼성시의버스노선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();

			int[] cnt = new int[5002];

			for (int j = 0; j < N; j++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				for (int k = A; k <= B; k++) {
					cnt[k]++;
				}
			}
			int P = sc.nextInt();

			System.out.print("#"+i);
			
			for (int k = 0; k < P; k++) {
				int c = sc.nextInt();
				System.out.print(" "+cnt[c]);
			}

			System.out.println();
		}

	}
}
