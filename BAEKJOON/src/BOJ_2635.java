import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		int max_cnt = 0;

		List<Integer> list = new LinkedList<Integer>();
		List<Integer> list_temp = new LinkedList<Integer>();

		for (int i = 1; i <= num; i++) {
			int a = num;
			int b = i;
			int cnt = 0;
			list_temp.add(a);
			list_temp.add(b);
			while (a - b >= 0) {
				cnt++;
				int temp = a;
				a = b;
				b = temp - b;
				list_temp.add(b);
			}
			if (cnt + 2 > max_cnt) {
				max_cnt = cnt + 2;
				list.clear();
				list.addAll(list_temp);
				list_temp.clear();
			} else {
				list_temp.clear();
			}
		}
		System.out.println(max_cnt);
		for (int j = 0; j < list.size(); j++)
			System.out.print(list.get(j) + " ");
	}
}
