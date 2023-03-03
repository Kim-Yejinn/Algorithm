import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_10811 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = i;
		}

		for (int k = 0; k < M; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			reverse(i, j);
		}
		for (int k = 1; k < N + 1; k++) {
			System.out.printf(arr[k] + " ");
		}
	}

	public static void reverse(int i, int j) {

		List<Integer> list = new ArrayList<Integer>();
		for (int k = i; k <= j; k++) {
			list.add(arr[k]);
		}
		for (int k = i, q = list.size() - 1; k <= j; k++, q--) {
			arr[k] = list.get(q);
		}
	}
}
