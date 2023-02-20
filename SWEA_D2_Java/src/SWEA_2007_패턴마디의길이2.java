import java.util.Scanner;

public class SWEA_2007_패턴마디의길이2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			char[] arr = sc.next().toCharArray();

			int min = 10;
			for (int j = 10; j > 0; j--) {
				char[] temp = new char[j];
				int flag = 0;
				for (int k = 0; k < j; k++) {
					temp[k] = arr[k];

				}
				stop: for (int q = 1; q < arr.length / j; q++) {
					for (int k = 0; k < j; k++) {
						if (temp[k] != arr[k + j * q]) {
							flag = 1;
							break stop;
						}
					}
					flag = 0;
				}

				if (flag == 0) {
					min = j;
				}

			}
			System.out.printf("#%d %d\n", i, min);

		}

	}
}
