import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static class Temp{
        int x;
        int y;
        Temp(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static class Node{
        int st;
        int ed;
        double length;

        Node(int st, int ed, double length){
            this.st = st;
            this.ed = ed;
            this.length = length;
        }
    }

    static double E;
    static double ans;
    static Temp[] nodeList;
    static List<Node>[] list;
    static boolean[] visit;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());

            nodeList = new Temp[N+1];
            list = new ArrayList[N+1];
            visit = new boolean[N+1];
            pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.length, o2.length));

            for(int i=1; i<=N; i++){
                list[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                int x = Integer.parseInt(st.nextToken());
                nodeList[i] = new Temp(x, 0);
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                int y = Integer.parseInt(st.nextToken());
                nodeList[i].y = y;
            }

            E = Double.parseDouble(br.readLine());
            ans = 0;

            for(int i=1; i<=N; i++){
                for(int j=i; j<=N; j++){
                    if(i!=j){
                        Temp s = nodeList[i];
                        Temp f = nodeList[j];

                        double length = (Math.pow(s.x-f.x, 2) + Math.pow(s.y - f.y,2)) * E;

                        list[i].add(new Node(i, j, length));
                        list[j].add(new Node(j, i, length));
                    }
                }
            }

            primMST();
            System.out.println("#"+tc+" "+Math.round(ans));

        }

    }

    public static void primMST(){
        pq.offer(new Node(1,1, 0));

        while(!pq.isEmpty()){
            Node temp = pq.poll();

            // 가장 작은 것 구함
            if(visit[temp.ed]){
                // 방문 했을 경우
                continue;
            }
            visit[temp.ed] = true;
            ans += temp.length;

            // 연결 된 것중에 방문 안한거 모두 넣기
            for(int i=0; i<list[temp.ed].size(); i++){
                Node next = list[temp.ed].get(i);
                if(!visit[next.ed]){
                    pq.offer(next);
                }
            }



        }
    }
}