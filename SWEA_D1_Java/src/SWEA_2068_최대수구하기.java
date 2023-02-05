import java.util.Scanner;

public class SWEA_2068_최대수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[10];
		int max = 0;

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();

			}
			for (int k = 0; k < 10; k++) {
				if (max < arr[k]) {
					max = arr[k];
				}
			}
			System.out.println("#" + (i + 1) + " " + max);
			max = 0;
		}

	}
}
