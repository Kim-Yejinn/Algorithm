import java.util.Scanner;

public class BOJ_1654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt(); // 이미 가지고 있는 랜선의 개수
		int N = sc.nextInt(); // 필요한 랜선의 개수

		int[] arr = new int[K];
		int max = 0; //최대길이
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			if (max < arr[i]) {
				max = arr[i]; 
			}
		}

		long start = 0;
		long end = max;

		long cnt = 0;

		long result = 0;
		while (start <= end) {
			long mid = (start + end) / 2;
			if (mid == 0) {
				mid = 1;
			}
			cnt = 0;
			for (int j = 0; j < K; j++) {
				cnt += arr[j] / mid;
			}
			if (cnt < N) {
				end = mid - 1;
			} else {
				start = mid + 1;
				result = mid;
			}

		}
		System.out.println(result);

	}
}
