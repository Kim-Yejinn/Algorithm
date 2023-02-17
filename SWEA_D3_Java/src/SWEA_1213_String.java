import java.util.Scanner;

public class SWEA_1213_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int T = sc.nextInt();

			char[] b = sc.next().toCharArray();
			char[] a = sc.next().toCharArray();

			int m = a.length;
			int n = b.length;

			int j = 0;
			int k = 0;
			int cnt = 0;

			while (j < m && k < n) {
				if (a[j] != b[k]) {
					j -= k;
					k = -1;
				} else if (a[j] == b[k] && k == n - 1) {
					cnt++;
					j -= k;
					k = -1;
				}
				j++;
				k++;
			}

			System.out.printf("#%d %d\n", i, cnt);

		}
	}
}
