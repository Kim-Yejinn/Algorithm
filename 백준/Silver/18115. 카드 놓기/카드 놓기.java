
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[N+1];

        for(int i=1; i<=N; i++){
            dq.addFirst(i);
        }

        String[] str = br.readLine().split(" ");

        for(int i=N; i>0; i--){
            int n = Integer.parseInt(str[N-i]);

            if(n==1){
                // 맨위 내려놓음
                int num = dq.removeLast();
                ans[num] = i;
            }else if(n==2){
                // 두번째 내려놓음
                int num1 = dq.removeLast();
                int num2 = dq.removeLast();
                dq.addLast(num1);
                ans[num2] = i;
            }else {
                // 마지막 내려 놓음
                int num = dq.removeFirst();
                ans[num] = i;
            }
        }

        // 출력
        for(int i=1; i<=N; i++){
            sb.append(ans[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
