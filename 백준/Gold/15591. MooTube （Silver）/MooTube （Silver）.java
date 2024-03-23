import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int ed;
        int dis;

        Node(int ed, int dis){
            this.ed = ed;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visit = new boolean[N+1];
            q.offer(v);
            visit[v] = true;
            int cnt = 0;

            while (!q.isEmpty()){
                int temp = q.poll();
                cnt++;

                for(int j=0; j<list[temp].size(); j++){
                    Node t = list[temp].get(j);

                    if(visit[t.ed]){
                        continue;
                    }
                    if(t.dis < k){
                        continue;
                    }

                    visit[t.ed] = true;
                    q.offer(t.ed);
                }
            }
            sb.append(cnt-1).append("\n");
        }
        System.out.println(sb);

    }
}