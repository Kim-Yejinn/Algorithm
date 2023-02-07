import java.util.Scanner;

public class SWEA_13218_조별과제 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			System.out.printf("#%d %d\n", i, N / 3);

		}

	}
}
