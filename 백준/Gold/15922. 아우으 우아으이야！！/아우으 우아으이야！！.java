import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node>{
        int st;
        int ed;

        Node(int st, int ed){
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Node o) {
            if(this.st == o.st){
                return this.ed - o.ed;
            }
            return this.st - o.st;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b));
        }

        Collections.sort(list);

        long sum = list.get(0).ed - list.get(0).st;
        int ed = list.get(0).ed;

        for(int i=0; i<N; i++){
            Node temp = list.get(i);
            if(ed > temp.st){
                int diff = temp.ed - ed;
                if(diff>0){
                    sum += diff;
                    ed = temp.ed;
                }
            }else{
                sum += temp.ed - temp.st;
                ed = temp.ed;
            }
        }
        System.out.println(sum);
    }
}