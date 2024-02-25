import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int num;
        int cnt;
        Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    static List<Integer>[] list;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            int res = bfs(i);

            if(min>res){
                ans = i;
                min = res;
            }
        }
        System.out.println(ans);

    }
    public static int bfs(int num){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(num, 0));

        boolean[] visit = new boolean[N+1];
        visit[num] = true;

        int dist = 0;

        while (!q.isEmpty()){
            Node temp = q.poll();

            dist += temp.cnt;

            for(int i=0; i<list[temp.num].size(); i++){
                int next = list[temp.num].get(i);

                if(!visit[next]){
                    visit[next] = true;
                    q.add(new Node(next, temp.cnt+1));
                }
            }
        }
        return dist;
    }
}