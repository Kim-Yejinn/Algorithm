import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i!=0){
                arr[i] += arr[i-1];
            }
        }

        long ans = 0;
        for(int i=0; i<N; i++){
            if(arr[i] == K){
                ans++;
            }
            if(map.containsKey(arr[i] - K)){
                ans += map.get(arr[i]-K);
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i])+1);
        }
        System.out.println(ans);
    }
}