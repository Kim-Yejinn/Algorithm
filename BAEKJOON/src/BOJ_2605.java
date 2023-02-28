import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new LinkedList<Integer>();

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			list.add(list.size() - num, i);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
