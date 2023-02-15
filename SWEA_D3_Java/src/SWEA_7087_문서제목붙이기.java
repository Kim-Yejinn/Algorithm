import java.util.Scanner;

public class SWEA_7087_문서제목붙이기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();

			String[] arr = new String[N];
			char[] cnt = new char[27];

			for (int j = 0; j < N; j++) {
				arr[j] = sc.next();
				cnt[arr[j].charAt(0) - 'A'] = 1;
			}

			for (int k = 0; k < 27; k++) {
				if (cnt[k] == 0) {
					System.out.println("#" + i + " " + k);
					break;
				}
			}

		}

	}
}
