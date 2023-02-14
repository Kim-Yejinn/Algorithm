import java.util.Scanner;

public class SWEA_4047_영준이의카드카운팅 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			String s = sc.next();

			int[] S = new int[14];
			int[] D = new int[14];
			int[] H = new int[14];
			int[] C = new int[14];

			int S_cnt = 13;
			int D_cnt = 13;
			int H_cnt = 13;
			int C_cnt = 13;

			int flag = 0;

			int cnt = s.length() / 3;

			for (int a = 0; a < cnt; a++) {
				char first = s.charAt(a * 3);
				int num = Integer.parseInt(s.substring(1 + 3 * a, 3 + 3 * a));

				switch (first) {
				case 'S':
					S[num]++;
					S_cnt--;
					if (S[num] == 2)
						flag = 1;
					break;
				case 'D':
					D[num]++;
					D_cnt--;
					if (D[num] == 2)
						flag = 1;
					break;
				case 'H':
					H[num]++;
					H_cnt--;
					if (H[num] == 2)
						flag = 1;
					break;
				case 'C':
					C[num]++;
					C_cnt--;
					if (C[num] == 2)
						flag = 1;
					break;
				}
			}
			
			

			if (flag == 1) {
				System.out.printf("#%d %s\n", i, "ERROR");
			} else {
				System.out.printf("#%d %d %d %d %d\n", i, S_cnt, D_cnt, H_cnt, C_cnt);
			}
		}

	}
}
