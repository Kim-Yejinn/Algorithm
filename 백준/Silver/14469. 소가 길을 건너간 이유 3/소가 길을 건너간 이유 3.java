import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int st;
        int time;

        Node(int st, int time){
            this.st = st;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(this.st == o.st){
                return this.time - o.time;
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

        int time = 0;
        for(int i=0; i<list.size(); i++){
            Node temp = list.get(i);

            if(time < temp.st){
                time = temp.st + temp.time;
            }else {
                time += temp.time;
            }
        }
        System.out.println(time);
    }
}