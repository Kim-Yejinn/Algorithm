import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        String str;
        int cnt;

        Node(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }

        @Override
        public int compareTo( Node o) {
            if(this.cnt == o.cnt){
                if(this.str.length() == o.str.length()){
                    return this.str.compareTo(o.str);
                }else{
                    return o.str.length() - this.str.length();
                }
            }
            return o.cnt - this.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;

        List<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String input = br.readLine();

            if(input.length()>=M){
                if(!map.containsKey(input)){
                    map.put(input, idx++);
                    list.add(new Node(input, 1));
                }else{
                    int t = map.get(input);
                    list.get(t).cnt = list.get(t).cnt+1;
                }
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).str).append("\n");
        }
        System.out.println(sb);
    }
}