import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int st;
        int ed;
        int weight;

        Node(int st, int ed, int weight){
            this.st = st;
            this.ed = ed;
            this.weight = weight;
        }
    }

    static int V;
    static int E;
    static List<Node>[] list;
    static boolean[] visit;
    static PriorityQueue<Node> q;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        visit = new boolean[V+1];
        q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        sum = 0;

        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(s, f, w));
            list[f].add(new Node(f, s, w));
        }
        primMST();
        System.out.println(sum);

    }

    public static void primMST(){
        q.offer(new Node(1, 1, 0));

        while(!q.isEmpty()){
            Node temp = q.poll();

            // weight 가장 작은 것 가져오기
            // 방문 여부 확인
            if(visit[temp.ed]){
                continue;
            }
            sum+= temp.weight;
            visit[temp.ed] = true;

            for(int i=0 ;i<list[temp.ed].size(); i++) {
                // 연결 된것 돌면서 방문하지 않은 것 모두
                Node next = list[temp.ed].get(i);
                if (!visit[next.ed]) {
                    q.offer(next);
                }
            }
        }

    }
}