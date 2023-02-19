import java.util.Scanner;

public class BOJ_2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int state = 0;
		int flag = 3;
		for (int i = 1; i < 9; i++) {
			int temp = sc.nextInt();

			if (i == 1 && temp == i) {
				flag = 1;
			}
			if (i == 1 && temp == 9 - i) {
				flag = 2;
			}

			if (temp == i && flag == 1) {
				state = 1;
			}
			if (temp == 9 - i && flag == 2) {
				state = 2;
			}

			if ((temp != i && flag == 1) || (temp != 9 - i && flag == 2)) {
				flag = 3;
			}

		}
		if (flag == 3) {
			System.out.println("mixed");
		} else {
			if (state == 1) {
				System.out.println("ascending");
			} else if (state == 2) {
				System.out.println("descending");
			}
		}
	}
}
