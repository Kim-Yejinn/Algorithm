import java.util.Scanner;

public class SWEA_4698_테네스의특별한소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] arr = new boolean[1000001];
		arr[0]=true;
		arr[1]=true;
		for (int i = 2; i <= 1000000; i++) {
			if (arr[i] == false) {
				int mul = 2;
				while (mul * i <= 1000000) {
					arr[mul * i] = true;
					mul++;
				}
			}
		}

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int cnt = 0;

			for (int j = A; j <= B; j++) {

				if (include(D, j) && (!arr[j])) {
					cnt++;
				}

			}
			System.out.printf("#%d %d\n",i,cnt);

		}
	}

	static boolean include(int D, int num) {
		int temp = num;
		while (temp > 0) {
			if (temp % 10 == D) {
				return true;
			}
			temp /= 10;
		}

		return false;

	}

}
