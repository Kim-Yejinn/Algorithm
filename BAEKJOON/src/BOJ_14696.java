import java.util.Scanner;

public class BOJ_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int[] cnt_a = new int[5];
			int[] cnt_b = new int[5];

			int a = sc.nextInt();

			for (int j = 0; j < a; j++) {
				cnt_a[sc.nextInt()]++;
			}

			int b = sc.nextInt();

			for (int j = 0; j < b; j++) {
				cnt_b[sc.nextInt()]++;
			}

			for (int t = 4; t > 0; t--) {
				if (cnt_a[t] > cnt_b[t]) {
					System.out.println("A");
					break;
				} else if (cnt_a[t] < cnt_b[t]) {
					System.out.println("B");
					break;
				}
				if (t == 1) {
					System.out.println("D");
				}
			}

		}

	}
}
