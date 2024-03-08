import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        int stress = 0;

        int cnt = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            stress += num;
            pq.offer(num);
            if(stress >= M){
                cnt++;
                stress -= pq.poll()*2;
            }
        }
        System.out.println(cnt);

    }
}