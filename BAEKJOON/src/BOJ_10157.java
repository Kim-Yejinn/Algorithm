import java.util.Scanner;

public class BOJ_10157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();

		int K = sc.nextInt();

		if (K > C * R) {
			System.out.println(0);
		} else {

			int temp_c = R;
			int temp_r = C - 1;
			int row = 0;
			int col = 1;
			int flag = 1;
			int cnt = 0;
			int flag_cnt = 0;
			while (temp_c > 0 || temp_r > 0) {
				cnt++;
				flag_cnt++;
				switch (flag) {
				case 1:
					row++;
					if (flag_cnt == temp_c) {
						flag = 2;
						flag_cnt = 0;
						temp_c--;
					}
					break;
				case 2:
					col++;
					if (flag_cnt == temp_r) {
						flag = 3;
						temp_r--;
						flag_cnt = 0;
					}
					break;
				case 3:
					row--;
					if (flag_cnt == temp_c) {
						flag = 4;
						flag_cnt = 0;
						temp_c--;
					}
					break;
				case 4:
					col--;
					if (flag_cnt == temp_r) {
						flag = 1;
						temp_r--;
						flag_cnt = 0;
					}
					break;
				}

				if (cnt == K) {
					break;
				}
			}
			System.out.println(col + " " + row);

		}
	}
}
