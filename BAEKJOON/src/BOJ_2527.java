import java.util.Scanner;

public class BOJ_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int j = 0; j < 4; j++) {
			int[] sq1 = new int[4];
			int[] sq2 = new int[4];

			for (int i = 0; i < 4; i++) {
				sq1[i] = sc.nextInt();
			}
			for (int i = 0; i < 4; i++) {
				sq2[i] = sc.nextInt();
			}

			char status = 'd';
			if (sq1[0] <= sq2[0] && sq1[1] <= sq2[1] && sq1[2] >= sq2[2] && sq1[3] >= sq2[3]) {
				status = 'a';
			}else if (sq1[0] > sq2[0] && sq1[1] > sq2[1] && sq1[2] < sq2[2] && sq1[3] < sq2[3]) {
				status = 'a';
			}
			else {
				if (sq1[1] == sq2[3]) {
					if (sq1[2] == sq2[0]) {
						status = 'c';
					} else {
						status = 'b';
					}
				}
				if (sq1[3] == sq2[1]) {
					if (sq1[2] == sq2[0]) {
						status = 'c';
					} else {
						status = 'b';
					}
				}
				if (sq1[2] == sq2[0]) {
					if (sq1[1] == sq2[3]) {
						status = 'c';
					} else {
						status = 'b';
					}
				}
				if (sq1[0] == sq2[2]) {
					if (sq1[1] == sq2[3]) {
						status = 'c';
					} else {
						status = 'b';
					}
				}
			}
			System.out.println(status);

		}
	}
}
