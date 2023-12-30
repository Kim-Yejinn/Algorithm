import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int[31][31];
		
		dp[1][1] = 1;   //1을 처음의 시작으로 설정
		dp[2][1] = 1;
		dp[2][2] = 1;
		for(int i=3; i<=30; i++) { 
			dp[i][1] = 1;  //처음은 0
			for(int j=2; j<i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
			dp[i][i] = 1;  //끝 값도 0
			
		}
		
		int sum = 0;  //삼각형을 더한 값
		for(int i=1; i<=w; i++) {
			for(int j=1; j<=i; j++) sum += dp[r+i-1][c+j-1];
		}
		System.out.println(sum);
		
	}
}