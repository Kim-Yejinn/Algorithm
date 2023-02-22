import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];

		System.out.println(n);
		Stack<Integer> st = new Stack<>();

		int cnt = 1;
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			System.out.println(temp);
			boolean flag = true;
			while (flag) {
				System.out.println("반복");
				if (!st.isEmpty() && st.peek() != temp) {
					st.push(cnt++);
					System.out.println('+');
				} else if (!st.isEmpty() && st.peek() == temp) {
					flag = false;
					st.pop();
					System.out.println('-');
				}

			}
		}

	}
}
