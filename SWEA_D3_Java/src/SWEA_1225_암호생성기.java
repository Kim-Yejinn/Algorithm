import java.util.Scanner;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();

			int[] arr = new int[8];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
				if (min > arr[i]) {
					min = arr[i];
				}
			}

			int temp = min / 15 - 1;

			for (int i = 0; i < 8; i++) {
				arr[i] -= 15 * temp;
			}

			int cnt = 1;
			int idx = 0;
			int j = 0;

			while (true) {
				arr[j] -= cnt;
				cnt++;

				if (cnt == 6) {
					cnt = 1;
				}
				if (arr[j] <= 0) {
					arr[j] = 0;
					idx = j;
					break;
				}

				j++;
				if (j >= 8) {
					j = 0;
				}
			}

			System.out.printf("#" + tc);
			for (int i = idx + 1; i < idx + 9; i++) {
				if (i >= 8) {
					System.out.print(" " + arr[i - 8]);
				} else {
					System.out.print(" " + arr[i]);
				}
			}
			System.out.println();
		}
	}
}
