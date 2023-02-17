import java.util.Scanner;

public class SWEA_1945_간단한소인수분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int a = 0, b = 0, c = 0, d = 0, e = 0;

		for (int i = 1; i <= T; i++) {

			long N = sc.nextLong();

			while (N % 2 == 0) {
				a++;
				N /= 2;
			}
			while (N % 3 == 0) {
				b++;
				N /= 3;
			}
			while (N % 5 == 0) {
				c++;
				N /= 5;
			}
			while (N % 7 == 0) {
				d++;
				N /= 7;
			}
			while (N % 11 == 0) {
				e++;
				N /= 11;
			}
			System.out.printf("#%d %d %d %d %d %d\n", i, a, b, c, d, e);
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;
		}

	}
}
