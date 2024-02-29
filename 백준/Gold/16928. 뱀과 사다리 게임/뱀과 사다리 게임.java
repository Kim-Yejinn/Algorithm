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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.put(a, b);
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));

        int ans = 0;
        int[] visit = new int[101];
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[1] = 0;


        while (!q.isEmpty()){
            Node temp = q.poll();

            if(temp.num == 100){
                ans = temp.cnt;
                break;
            }

            for(int i=1; i<=6; i++){
                int next = temp.num + i;

                if(map.containsKey(next)){
                    next = map.get(next);
                }

                if(next > 100){
                    continue;
                }

                if(visit[next] <= temp.cnt+1){
                    continue;
                }
                visit[next] = temp.cnt+1;
                q.offer(new Node(next, temp.cnt+1));
            }
        }
        System.out.println(ans);
    }
}