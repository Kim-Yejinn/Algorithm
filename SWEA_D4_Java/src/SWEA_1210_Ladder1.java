import java.util.Scanner;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int T = sc.nextInt();

			int[][] arr = new int[100][102];

			int start = 0;

			// 받음
			for (int r = 0; r < 100; r++) {
				for (int c = 1; c < 101; c++) {
					arr[r][c] = sc.nextInt();
					if (arr[r][c] == 2) {
						start = c;
					}
				}
			}
			

			int finish = 99;
			int left_flag = 0;
			int right_flag = 0;
			int up_flag = 1;

			while (finish >= 0) {
				if (arr[finish][start - 1] == 1 && up_flag == 1) {
					left_flag = 1;
					up_flag = 0;
				}
				if (arr[finish][start + 1] == 1 && up_flag == 1) {
					right_flag = 1;
					up_flag = 0;
				}
				if (arr[finish][start - 1] == 0 && left_flag == 1) {
					up_flag = 1;
					left_flag = 0;
				}
				if (arr[finish][start + 1] == 0 && right_flag == 1) {
					up_flag=1;
					right_flag=0;
				}
				
				if(up_flag==1) {
					finish--;
				}else if(left_flag==1) {
					start--;
				}else if(right_flag==1) {
					start++;
				}
				
			}
			
			System.out.printf("#%d %d\n",i,start-1);

		}

	}
}
