import java.util.Scanner;

public class BOJ_2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();

		int[] width = new int[w + 1];
		int[] height = new int[h + 1];

		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			int rc = sc.nextInt();
			int cut = sc.nextInt();

			if (rc == 0) {
				height[cut] = 1;
			} else {
				width[cut] = 1;
			}
		}
		int max_w = 0;
		int max_h = 0;
		int temp = 1;
		for (int i = 1; i <= w; i++) {
			if (width[i] == 0) {
				if (i != w) {
					temp++;
				}
				if (max_w < temp) {
					max_w = temp;
				}
			} else {
				if (max_w < temp) {
					max_w = temp;
				}
				temp = 1;
			}

		}
		temp = 1;
		for (int i = 1; i <= h; i++) {
			if (height[i] == 0) {
				if (i != h) {
					temp++;
				}
				if (max_h < temp) {
					max_h = temp;
				}
			} else {
				if (max_h < temp) {
					max_h = temp;
				}
				temp = 1;
			}
		}
		if (max_w > w) {
			max_w = w;
		}
		if (max_h > h) {
			max_h = h;
		}
		System.out.println(max_w * max_h);

	}
}
