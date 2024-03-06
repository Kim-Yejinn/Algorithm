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

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N+1];
        int len = 0;
        int max = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(!map.containsKey(arr[i])){
                map.put(arr[i], 0);
            }

            if(map.get(arr[i])>=K){
                while (len != 0){
                    map.put(arr[i-len], map.get(arr[i-len])-1);
                    if(arr[i] == arr[i-len]){
                        len--;
                        break;
                    }
                    len--;
                }
                map.put(arr[i], map.get(arr[i])+1);
                len++;
            }else{
                map.put(arr[i], map.get(arr[i])+1);
                len++;
            }
            max = Math.max(max, len);
        }
        System.out.println(max);
    }
}