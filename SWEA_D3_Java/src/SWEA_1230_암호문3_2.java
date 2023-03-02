import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1230_암호문3_2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int N = sc.nextInt();

			List<String> input = new LinkedList<>();

			for (int j = 0; j < N; j++) {
				input.add(sc.next());
			}

			int M = sc.nextInt();
			List<String> op = new LinkedList<>();

			int cnt = 0;
			int a = 0;
			int b = 0;
			int c = 0;

			while (cnt < M + a + b) {
				String tmp = sc.next();
				op.add(tmp);

				if (a == 2) {
					cnt++;
					c++;
					if (c == 2) {
						b = Integer.parseInt(tmp);
					}
				}
				if (a == 1) {
					cnt++;
					c++;
					if (c == 1) {
						b = Integer.parseInt(tmp);
					}
				}

				if (c == -1) {
					cnt++;
				}

				if (tmp.charAt(0) == 'I') {
					cnt++;
					if (cnt == M)
						a = 2;
				} else if (tmp.charAt(0) == 'A') {
					cnt++;
					if (cnt == M)
						a = 1;
				} else if (tmp.charAt(0) == 'D') {
					cnt++;
					if (cnt == M)
						c = -1;
					b = 2;
				}

			}

			for (int idx = 0; idx < op.size();) {
				switch (op.get(idx++).charAt(0)) {

				case 'I':
					int x = Integer.parseInt(op.get(idx++));
					int y = Integer.parseInt(op.get(idx++));
					for (int j = 0; j < y; j++) {
						input.add(x, op.get(idx++));
						x++;
					}
					break;
				case 'D':
					int x1 = Integer.parseInt(op.get(idx++));
					int y1 = Integer.parseInt(op.get(idx++));

					for (int j = 0; j < y1; j++) {
						input.remove(x1);
					}
					break;
				case 'A':
					int y2 = Integer.parseInt(op.get(idx++));
					String temp = "";

					for (int j = 0; j < y2; j++) {
						temp += op.get(idx++);
						temp += " ";
					}

					input.add(temp);
					break;
				}
			}

			System.out.print("#" + i);
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + input.get(j));
			}
			System.out.println("");

		}
	}
}