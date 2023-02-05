import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2050_알파벳을숫자로변환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] str;

		str = sc.next().split("");

		char[] c = new char[str.length];
		
		for (int i = 0; i < str.length; i++) {
			c[i] = str[i].charAt(0);
			System.out.print((int) c[i] - 64 + " ");
		}

	}
}
