import java.util.Scanner;

public class BOJ_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int j = 0; j < 4; j++) {
			int[] sq1 = new int[4]; // x, y, x, y
			int[] sq2 = new int[4];

			for (int i = 0; i < 4; i++) {
				sq1[i] = sc.nextInt();
			}
			for (int i = 0; i < 4; i++) {
				sq2[i] = sc.nextInt();
			}

			int[] min = new int[4];

			if (sq1[0] <= sq2[0]) {
				min[0] = sq2[0];
			} else {
				min[0] = sq1[0];
			}

			if (sq1[1] <= sq2[1]) {
				min[1] = sq2[1];
			} else {
				min[1] = sq1[1];
			}

			if (sq1[2] >= sq2[2]) {
				min[2] = sq2[2];
			} else {
				min[2] = sq1[2];
			}

			if (sq1[3] >= sq2[3]) {
				min[3] = sq2[3];
			} else {
				min[3] = sq1[3];
			}

			char status = 'd';

			if (min[0] < min[2] && min[1] < min[3]) {
				status = 'a';
			}
			if ((min[0] == min[2] && min[1] < min[3]) || (min[1] == min[3] && min[0] < min[2])) {
				status = 'b';
			}
			if (min[0] == min[2] && min[1] == min[3]) {
				status = 'c';
			}

			System.out.println(status);
		}
	}
}
