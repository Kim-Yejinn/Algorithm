import java.awt.List;
import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i < T; i++) {

			int num = sc.nextInt();

			int total_cal = sc.nextInt();

			int[] score = new int[num];
			int[] cal = new int[num];
			int[] cnt=new int[num];
			
			
			for (int j = 0; j < num; j++) {
				score[j] = sc.nextInt();
				cal[j] = sc.nextInt();
				cnt[j] = total_cal/cal[j];
			}
			
			int[] cnt_temp=cnt;
			
			int max = 0;
			int sum_cal = 0;

			
			
			
			
			
		}
	}
}