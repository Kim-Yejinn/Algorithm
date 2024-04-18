import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int r=1; r<=str1.length(); r++){
            char a = str1.charAt(r-1);
            for(int c=1; c<=str2.length(); c++){
                char b = str2.charAt(c-1);
                if(a == b){
                    dp[r][c] = dp[r-1][c-1] + 1;
                }else{
                    if(dp[r-1][c] >= dp[r][c-1]){
                        dp[r][c] = dp[r-1][c];
                    }else{
                        dp[r][c] = dp[r][c-1];
                    }
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);

        int rIdx = str1.length();
        int cIdx = str2.length();

        StringBuilder sb = new StringBuilder();
        while (rIdx > 0 && cIdx > 0){
            char a = str1.charAt(rIdx-1);
            char b = str2.charAt(cIdx-1);

            if(a == b){
                sb.append(a);
                rIdx--;
                cIdx--;
            }else{
                if(dp[rIdx][cIdx] == dp[rIdx-1][cIdx]){
                    rIdx--;
                }else if(dp[rIdx][cIdx] == dp[rIdx][cIdx-1]){
                    cIdx--;
                }
            }
        }
        System.out.println(sb.reverse());
    }
}