import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] left;
    static int[] right;

    static int cnt;
    static boolean[] visit;
    static int endIdx;

    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        left = new int[N+1];
        right = new int[N+1];
        visit = new boolean[N+1];
        cnt = 0;
        flag = false;

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            left[a] = b;
            right[a] = c;
        }
        endIdx = findend();
        rec(1);
        System.out.println(cnt);
    }

    public static int findend(){
        int idx = 1;
        int ans = 0;
        while (idx != -1){
            ans = idx;
            idx = right[idx];
        }
        return ans;
    }
    public static void rec(int num){
        if(flag){
            return;
        }

        int l = left[num];
        int r = right[num];

        if(l != -1 && !visit[l]){
            cnt++;
            rec(l);
        }
        if(flag){
            return;
        }
        if(r != -1 && !visit[r]){
            cnt++;
            rec(r);
        }
        if(flag){
            return;
        }
        if(endIdx == num){
            flag = true;
            return;
        }
        if(num != 1){
            cnt++;
        }
        visit[num] = true;
    }
}