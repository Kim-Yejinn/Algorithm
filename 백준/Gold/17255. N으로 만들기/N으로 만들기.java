import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> q = new LinkedList<>();

        int cnt = 0;

        String input = br.readLine();
        q.offer(input);

        while (!q.isEmpty()){
            String temp = q.poll();

            if(temp.length() == 1){
                cnt++;
                continue;
            }

            String left = temp.substring(1);
            String right = temp.substring(0, temp.length()-1);

            q.offer(left);

            if(!left.equals(right)){
                q.offer(right);
            }
        }
        System.out.println(cnt);
    }
}