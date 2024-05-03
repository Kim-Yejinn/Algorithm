import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Edge{
        int st;
        int ed;
        int cost;
        Edge(int st, int ed, int cost){
            this.st = st;
            this.ed = ed;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Edge> list = new ArrayList<>();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                list.add(new Edge(s, e, t));
                list.add(new Edge(e, s, t));
            }
            for(int i=0; i<W; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list.add(new Edge(s, e, -t));
            }

            int[] dist = new int[N+1];
            boolean flag = false;

            for(int i=1; i<=N; i++){
                for(int j=0; j<list.size(); j++){
                    Edge temp = list.get(j);

                    int dis = dist[temp.st] + temp.cost;

                    if(dist[temp.ed] > dis){
                        dist[temp.ed] = dis;

                        if(i==N){
                            flag = true;
                        }
                    }
                }
            }

            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

}