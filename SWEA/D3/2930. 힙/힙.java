import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc);
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for(int i=0 ;i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());

                if(op==1){
                    int num = Integer.parseInt(st.nextToken());
                    pq.add(num);
                }else{
                    if(pq.isEmpty()){
                        sb.append(" ").append("-1");
                    }else{
                        sb.append(" ").append(pq.poll());
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}