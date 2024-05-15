import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        long sum = 0;
        for(int i=0; i<N; i++){
            int t = Integer.parseInt(st.nextToken());
            list.add(t);
            sum += t;
        }

        Collections.sort(list);

        long ans = 0;
        for(int i=0; i<N-1; i++){
            int t = list.get(i);
            sum -= t;
            ans += sum * t;
        }
        System.out.println(ans);
    }
}