import java.util.Scanner;

public class SWEA_1940_가랏RC카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();

			int speed = 0;
			int ctrl = 0;
			int total = 0;

			for (int j = 0; j < N; j++) {

				ctrl = sc.nextInt();

				if (ctrl == 1) {
					speed += sc.nextInt();
				} else if (ctrl == 2) {
					int temp = sc.nextInt();
					if (speed >= temp)
						speed -= temp;
				}

				total += speed;

			}

			System.out.printf("#%d %d\n", i, total);

		}

	}
}
