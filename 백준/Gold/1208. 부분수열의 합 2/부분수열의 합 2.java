import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static long ans;

    static Map<Long, Long> map;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        if(S == 0){
            // 둘다 공집합일때
            ans = -1;
        }else{
            ans = 0;
        }
        map = new HashMap<>();

        int M = N/2;

        st = new StringTokenizer(br.readLine());

        arr = new long[N];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        leftSearch(0, M, 0);
        rightSearch(M, N, 0);

        System.out.println(ans);
    }

    public static void leftSearch(int l, int r, long sum){
        if(l == r){
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1L);
            }
            return;
        }

        leftSearch(l+1, r, sum);
        leftSearch(l+1, r, sum + arr[l]);
    }

    public static void rightSearch(int l, int r, long sum){
        if(l == r){
            long num = S - sum;

            if(map.containsKey(num)) {
                ans += map.get(num);
                return;
            }
            if(sum == S){
                ans++;
            }
            return;
        }

        rightSearch(l+1, r, sum);
        rightSearch(l+1, r, sum + arr[l]);
    }

}