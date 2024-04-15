import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];
        int[] last = new int[N];

        int max = 0;
        int idx = 0;

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            last[i] = i;
            for(int j=0; j<i; j++){
                if(A[j] < A[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    last[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (idx != last[idx] ){
            list.add(A[idx]);
            idx = last[idx];
        }
        list.add(A[idx]);

        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}