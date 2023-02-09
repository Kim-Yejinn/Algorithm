import java.util.Scanner;

public class BOJ_2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = 0;
		int idx = 0;
		for (int i = 1; i < 10; i++) {
			int temp = sc.nextInt();
			if (max < temp) {
				max = temp;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}
