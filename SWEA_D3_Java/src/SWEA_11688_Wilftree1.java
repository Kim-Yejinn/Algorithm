import java.util.Scanner;

public class SWEA_11688_Wilftree1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			String s = sc.next();
			int u = 1; // u/d
			int d = 1;

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'L') {
					d += u;
				} else if (s.charAt(j) == 'R') {
					u += d;
				}
			}
			int a = u;
			int b = d;

			while (true) {

				if (a > b) {
					a -= b;

				} else if (a < b) {
					b -= a;
				}

				if (a == b) {
					break;
				}
			}

			u /= a;
			d /= a;
			System.out.printf("#%d %d %d\n", i, u, d);

		}
	}

}
