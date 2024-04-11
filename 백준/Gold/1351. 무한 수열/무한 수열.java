import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Long, Long> map;
    static long N;
    static long P;
    static long Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);
        System.out.println(rec(N));
    }

    public static long rec(long num){
        if(map.containsKey(num)){
            return map.get(num);
        }
        long sum = rec(num/P) + rec(num/Q);
        map.put(num, sum);
        return sum;
    }
}