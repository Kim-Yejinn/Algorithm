import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int first;
        int second;
        Node(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo( Node o) {
            return this.first - o.first;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            List<Node> list = new ArrayList<>();

            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Node(a, b));
            }

            Collections.sort(list);

            int ans = 0;
            int last = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                Node temp = list.get(i);
                if(last > temp.second){
                    ans++;
                    last = temp.second;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}