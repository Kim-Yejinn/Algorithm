import java.util.Scanner;

public class SWEA_1220_Magnetic {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();
			int[] arr = new int[100];

			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					int temp = sc.nextInt();

					if (temp == 1) {
						if (arr[c] == 0)
							arr[c] = 1;
					} else if (temp == 2) {
						if (arr[c] == 1) {
							cnt++;
							arr[c] = 0;
						}
					}

				}

			}
			System.out.printf("#%d %d\n", i, cnt);
		}
	}
}
