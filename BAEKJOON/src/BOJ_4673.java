import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_4673 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean[] check = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {
			int temp = sum(i);
			if (temp < 10001)
				check[temp] = true;
		}
		for (int i = 1; i <= 10000; i++) {
			if (check[i] == false)
				System.out.println(i);
		}

	}

	public static int sum(int num) {

		int sum = num;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
