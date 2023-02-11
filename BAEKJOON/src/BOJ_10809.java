import java.util.Scanner;

public class BOJ_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		int[] cnt = new int[26];

		for (int j = 0; j < 26; j++) {
			cnt[j] = -1;
		}
		for (int i = 0; i < S.length(); i++) {
			if (cnt[S.charAt(i) - 'a'] == -1) {
				cnt[S.charAt(i) - 'a'] = i;

			}
		}
		for (int j = 0; j < 26; j++) {
			if (cnt[j] >= 0)
				System.out.print(cnt[j] + " ");
			else {
				System.out.print("-1 ");
			}
		}

	}
}
