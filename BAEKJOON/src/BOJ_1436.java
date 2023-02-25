import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 자리수 확인
		int n = 1;
		int sum = 1;
		int num = 1;
		int[] num_arr = new int[6];

		num_arr[0] = 1;

		while (N > sum) {
			n++;
			num = num * 9 + (int) Math.pow(10, n - 1);
			num_arr[n - 1] = num;
			sum += num;
		}
//		N -= sum - num;
		n--;
		System.out.println(N);
		System.out.println("n은" + n);
		System.out.println(Arrays.toString(num_arr));
//		n += 3;

		int flag = 0; // 6이 앞인가??
		String result = "";
		if (N >= 1) {
			N -= 1;
		}
		s: for (int j = 1; j <= n; j++) {
			System.out.println("자리수 시작" + N);
			System.out.println(num_arr[n - j]);
//			N-=1;			
			int cnt = 0;
			
			if (N == 1 && j != 1) {
				N -= 1;
				result += 0;
				break;
			}

			for (int i = 1; i <= 5; i++) {
				if (N >= num_arr[n - j]) {
					N -= num_arr[n - j];
					cnt++;
				} else {
					result += cnt;
					continue s;
				}
			}

			if (N > Math.pow(10, n + 1 - j)) {
				N -= Math.pow(10, n + 1 - j);
				cnt++;
			} else if (N == 0) {
				result += cnt;
				continue s;
			} else {
				cnt++;
				N -= 1;
				flag = 1;
				break s;
			}

			for (int i = 0; i < 3; i++) {
				if (N >= num_arr[n - j]) {
					N -= num_arr[n - j];
					cnt++;
				} else {
					result += cnt;
					continue s;
				}
			}
			result += cnt;

		}
		result += "666";
		System.out.println(N);
		if (flag == 1) {
			result += N;
		}

		System.out.println(result);

	}
}
