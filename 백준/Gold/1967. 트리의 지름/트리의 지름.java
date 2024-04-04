import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int ed;
        int dis;
        Node(int ed, int dis){
            this.ed = ed;
            this.dis = dis;
        }
    }

    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }


        int max = 0;
        for(int i=1; i<=N; i++){
            List<Integer> ans = new ArrayList<>();

            for(int j=0; j<list[i].size(); j++){
                Node temp = list[i].get(j);

                ans.add(rec(temp.ed)+ temp.dis);
            }

            Collections.sort(ans, Collections.reverseOrder());

            if(ans.size() == 1){
                max = Math.max(max, ans.get(0));
            }else if(ans.size() >= 2){
                max = Math.max(max, ans.get(0) + ans.get(1));
            }
        }
        System.out.println(max);

    }



    public static int rec(int node){
        int sum = 0;
        for(int i=0; i<list[node].size(); i++){
            Node temp = list[node].get(i);

            int t = rec(temp.ed);
            sum = Math.max(sum, t + temp.dis);
        }
        return sum;
    }
}