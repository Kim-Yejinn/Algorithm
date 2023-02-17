import java.util.Scanner;

public class SWEA_1926_간단한369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			int flag = 0;
			String temp = Integer.toString(i);
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
					System.out.print('-');
					flag = 1;
				}
			}
			if (flag != 1) {
				System.out.print(i);
			}

			System.out.print(" ");

		}
	}
}
