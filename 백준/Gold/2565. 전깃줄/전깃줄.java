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
        int ed;

        Node(int st, int ed){
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Node o) {
            return this.ed - o.ed;
        }
    }

    static List<Node> list;
    static int[] dp;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b));
        }

        Collections.sort(list);

        dp = new int[list.size()];

        dp[0] = list.get(0).st;
        size = 1;

        for(int i=1; i<N; i++){
            int t = list.get(i).st;

            if(dp[size-1] < t){
                dp[size++] = t;
            }else{
                int idx = search(t);
                dp[idx] = t;
            }
        }

        System.out.println(N - size);

    }

    public static int search(int num){
        int left = 0;
        int right = size-1;

        while (left < right){
            int mid = (left+right) / 2;

            if(dp[mid] < num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }

}