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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> list = new ArrayList<>();
        long[] dist = new long[N+1];
        boolean flag = false;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a, b, c));
        }
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[1] = 0;

        // N-1 번 반복 + 음수 사이클 여부 확인
        // 왜 N-1? 음수 사이클이 존재하지 않을 경우 N-1 이면 모든 간선에 대해 완화가 완료됨.
        // 만약 음수 사이클이 존재할 경우 N 번째에도 변경이 일어나서 이성질을 이용해서 음수 사이클을 확인하는 것임.
        for(int i=1; i<=N; i++){
            for(int j=0; j<list.size(); j++){
                Edge temp = list.get(j);

                // 시작점을 아직 도착하지 않았을 경우
                if(dist[temp.st] == Long.MAX_VALUE){
                    // 넘긴다
                    continue;
                }

                // 새로운 거리
                long dis = dist[temp.st] + temp.cost;

                // 새로운 거리가 더 짧은 거리일 때 갱신
                if(dist[temp.ed] > dis){
                    dist[temp.ed] = dis;
                    if(i == N){
                        // N 번째에 값이 변경되면 음수 사이클이 존재한다는 뜻임
                        flag = true;
                        break;
                    }
                }

            }
        }

        if(flag){
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=2; i<=N; i++){
                if(dist[i] == Long.MAX_VALUE){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.println(sb);
        }
    }
}