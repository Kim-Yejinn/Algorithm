import java.util.Scanner;

public class SWEA_10570_제곱팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int A = sc.nextInt();
			int B = sc.nextInt();

			int sA = (int) Math.sqrt(A);
			if (A == sA * sA) {
				sA -= 1;
			}

			int sB = (int) Math.sqrt(B);

			int cnt = 0;
			for (int j = sA + 1; j <= sB; j++) {

				if (pal(j)) {
					if (pal(j * j)) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n", i, cnt);

		}
	}

	static boolean pal(int num) {

		String temp = String.valueOf(num);

		int n = temp.length();
		boolean check = true;

		for (int i = 0; i < n / 2; i++) {
			if (temp.charAt(i) != temp.charAt(n - 1)) {
				check = false;
				break;
			}
		}
		return check;
	}
}
