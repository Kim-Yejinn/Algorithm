import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static List<Integer> ans;
    static int[] dp;
    static int[] last;
    static int[] curIdx;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        ans = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b));
        }

        Collections.sort(list);

        dp = new int[list.size()];
        last = new int[list.size()];
        curIdx = new int[list.size()];

        dp[0] = list.get(0).st;
        size = 1;

        for(int i=1; i<N; i++){
            Node t = list.get(i);
            last[i] = i;

            if(dp[size-1] < t.st){
                last[i] = curIdx[size-1];
                curIdx[size] = i;
                dp[size++] = t.st;
            }else{
                int idx = search(t.st);
                if(idx != 0){
                    last[i] = curIdx[idx-1];
                }
                dp[idx] = t.st;
                curIdx[idx] = i;
            }
        }

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append(N-size).append("\n");
        int idx = curIdx[size-1];

        while (idx != last[idx]){
            set.add(list.get(idx).st);
            idx = last[idx];
        }
        set.add(list.get(idx).st);

        for(int i=0; i<list.size(); i++){
            int t = list.get(i).st;
            if(!set.contains(t)){
                ans.add(t);
            }
        }
        Collections.sort(ans);
        for(int i=0; i<ans.size(); i++){
            int t = ans.get(i);
            sb.append(t).append("\n");
        }
        System.out.println(sb);
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