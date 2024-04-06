import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if(o.y == this.y){
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, 0));
        }

        Collections.sort(list);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));

        boolean[] visit = new boolean[list.size()];
        int ans = -1;

        while (!q.isEmpty()){
            Node temp = q.poll();

            if(temp.y == T){
                ans = temp.cnt;
                break;
            }

            for(int i=0; i<list.size(); i++){
                if(visit[i]){
                    continue;
                }
                Node t = list.get(i);

                if(Math.abs(t.x - temp.x) > 2){
                    continue;
                }

                if((t.y - temp.y) > 2){
                    break;
                }
                if((temp.y - t.y) > 2){
                    continue;
                }
                visit[i] = true;
                q.offer(new Node(t.x, t.y, temp.cnt+1));
            }
        }
        System.out.println(ans);
    }
}