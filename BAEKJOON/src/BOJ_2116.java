import java.util.Scanner;

public class BOJ_2116 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] pre = new int[6];
		int[] rev = new int[6];
		int[] sum = new int[6];

		for (int i = 0; i < 6; i++) {
			int t = sc.nextInt();
			switch (i) {
			case 0:
				pre[5] = t;
				break;
			case 1:
				pre[3] = t;
				break;
			case 2:
				pre[4] = t;
				break;
			case 3:
				pre[1] = t;
				break;
			case 4:
				pre[2] = t;
				break;
			case 5:
				pre[0] = t;
				break;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 6; j++) {

			}
		}

	}
}
