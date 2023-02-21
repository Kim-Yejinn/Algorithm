import java.util.Scanner;

public class BOJ_2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] arr = sc.next().toCharArray();

		String[] str = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		int cnt = 0;
		S: for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < str.length; k++) {
				boolean flag = true;
				for (int j = 0; j < str[k].length(); j++) {
					if (i + j < arr.length) {
						if (arr[i + j] != str[k].charAt(j)) {
							flag = false;
							break;
						}
					}
				} 
				if (flag == true) {
					cnt++;
					if (k == 2) {
						i += 2; 
					} else {
						i++;
					}
					continue S;
				}
				if (k == str.length - 1) {
					cnt++;
				}
			}

		}
		System.out.println(cnt);
	}
}
