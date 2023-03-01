import java.util.Scanner;

public class BOJ_10158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();

		int p = sc.nextInt();
		int q = sc.nextInt();

		int t = sc.nextInt();

		p += (t % (2 * w));
		if (p >= 2 * w) {
			p -= 2 * w;
		}
		if (p >= w) {
			p = 2 * w - p;
		}
		q += (t % (2 * h));
		if (q >= 2 * h) {
			q -= 2 * h;
		}
		if (q >= h) {
			q = 2 * h - q;
		}
		System.out.println(p + " " + q);

	}
}
