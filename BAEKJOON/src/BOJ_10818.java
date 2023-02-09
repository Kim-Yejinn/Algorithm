import java.util.Scanner;

public class BOJ_10818 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int min = 1000000;
		int max = -1000000;
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			if (temp > max)
				max = temp;
			if (temp < min)
				min = temp;
		}
		System.out.println(min + " " + max);
	}
}
