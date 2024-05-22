import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ans;
    static int[] sel;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = new int[12];
        sel = new int[12];
        cnt = 0;

        for(int i=2; i<12; i++){
            ans[i] = Integer.parseInt(st.nextToken());
        }
        dfs(2);
        System.out.println(cnt);

    }
    public static void dfs(int num){
        if(num == 12){
            int sum =0;
            for(int i=2; i<12; i++){
                if(sel[i] == ans[i]){
                    sum++;
                }
            }
            if(sum >= 5){
                cnt++;
            }
            return;
        }

        for(int i=1; i<=5; i++){
            if(sel[num-1] == sel[num-2] && sel[num-1] == i){
                continue;
            }
            sel[num] = i;
            dfs(num+1);
        }

    }
}