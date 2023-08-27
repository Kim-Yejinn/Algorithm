
import java.util.Scanner;

public class Main {

	static int N;
	static int R;
	static int C;
	static int cnt;
	static int ans;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		cnt = -1;
		flag = false;

		rec(0, 0, 2 << N - 1);
		System.out.println(ans);
	}

	public static void rec(int r, int c, int num) {
		if (flag) {
			return;
		}

		if (num == 2) {
			cnt++;
			if (r == R && c == C) {
				ans = cnt;
				flag = true;
			}
			cnt++;
			if (r == R && c + 1 == C) {
				ans = cnt;
				flag = true;
			}
			cnt++;
			if (r + 1 == R && c == C) {
				ans = cnt;
				flag = true;
			}
			cnt++;
			if (r + 1 == R && c + 1 == C) {
				ans = cnt;
				flag = true;
			}
			return;
		}
		if (R < r + num / 2 && C < c + num / 2) {
			rec(r, c, num / 2);
		}
		cnt += (num / 2) * (num / 2);

		if (R < r + num / 2 && C >= c + num / 2) {
			rec(r, c + num / 2, num / 2);
		}
		cnt += (num / 2) * (num / 2);

		if (R >= r + num / 2 && C < c + num / 2) {
			rec(r + num / 2, c, num / 2);
		}
		cnt += (num / 2) * (num / 2);

		if (R >= r + num / 2 && C >= c + num / 2) {
			rec(r + num / 2, c + num / 2, num / 2);
		}

	}
}
