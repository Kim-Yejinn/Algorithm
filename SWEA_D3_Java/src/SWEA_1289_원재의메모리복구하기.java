import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			String ans = sc.next();
			int cnt = 0;

			// 초기 배열 생성
			int[] arr = new int[ans.length()];

			int[] ans_arr = new int[ans.length()];

			for (int j = 0; j < ans.length(); j++) {

				ans_arr[j] = ans.charAt(j) - '0';

			}

			for (int j = 0; j < ans.length(); j++) {

				if (ans_arr[j] != arr[j]) {
					cnt++;
					for (int k = j; k < ans.length(); k++) {

						if (arr[k] == 1) {
							arr[k] = 0;
						} else {
							arr[k] = 1;
						}

					}

				}

			}
			
			System.out.printf("#%d %d\n",i,cnt);

		}
	}
}
