import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		int sum = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		Arrays.sort(arr);

		int diff = sum - 100;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i != j) {
					if (arr[i] + arr[j] == diff) {

						for (int k = 0; k < 9; k++) {
							if (k != i && k != j) {
								System.out.println(arr[k]);

							}
						}
						return;
					}
				}
			}
		}
	}
}
