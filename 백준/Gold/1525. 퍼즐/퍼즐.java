import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        String str;
        int r;
        int c;
        int cnt;
        Node(String str, int r, int c, int cnt){
            this.str = str;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int idxR = 0;
        int idxC = 0;

        for(int r=0; r<3; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<3; c++){
                int t = Integer.parseInt(st.nextToken());
                if(t == 0){
                    idxR = r;
                    idxC = c;
                }
                input += t;
            }
        }

        Set<String> set = new HashSet<>();
        set.add(input);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(input, idxR, idxC,0));

        int ans = -1;

        while (!q.isEmpty()){
            Node temp = q.poll();
            if(temp.str.equals("123456780")){
                ans = temp.cnt;
                break;
            }
            for(int i=0; i<4; i++){
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if(nr<0 ||nc<0|| nr>=3|| nc>=3){
                    continue;
                }
                int a = Math.min(temp.r * 3 + temp.c, nr * 3 + nc);
                int b = Math.max(temp.r * 3 + temp.c, nr * 3 + nc);

                String make = temp.str.substring(0, a) + temp.str.charAt(b) + temp.str.substring(a+1, b) + temp.str.charAt(a) + temp.str.substring(b+1);

                if(!set.contains(make)){
                    set.add(make);
                    q.offer(new Node(make, nr, nc, temp.cnt+1));
                }
            }
        }
        System.out.println(ans);
    }
}