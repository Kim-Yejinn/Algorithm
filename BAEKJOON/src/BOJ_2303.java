import java.util.Scanner;

public class BOJ_2303 {
	static int[] arr = new int[5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max_num = 0;
		int max_person = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				arr[j] = sc.nextInt();
			}
			int t = num();
			if (t >= max_num) {
				max_num = t;
				max_person = i;
			}
		}
		System.out.println(max_person + 1);
	}

	public static int num() {
		int temp = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i != j) {
					for (int k = 0; k < 5; k++) {
						if (i != k && j != k) {
							int t = arr[i] + arr[j] + arr[k];
							t %= 10;
							if (temp < t) {
								temp = t;
							}
						}
					}
				}
			}
		}
		return temp;
	}
}
