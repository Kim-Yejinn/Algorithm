import java.util.Scanner;

public class BOJ_2810 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String str = sc.next();

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'L') {
				i++;
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println(N);
		} else {
			System.out.println(N + 1 - cnt);
		}
	}
}
