import java.util.Scanner;

public class SWEA_7102_준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			System.out.print("#" + i);
			if (N > M) {
				for (int j = M + 1; j <= N + 1; j++) {
					System.out.print(" " + j);
				}
			} else if (N < M) {
				for (int j = N + 1; j <= M + 1; j++) {
					System.out.print(" " + j);
				}
			} else {
				System.out.print(" " + (N + 1));
			}
			System.out.println();
		}

	}
}
