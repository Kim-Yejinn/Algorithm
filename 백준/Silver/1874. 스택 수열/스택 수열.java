

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();

        int idx = 1 ;


        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            boolean flag = true;

            while(flag){
                if(!st.isEmpty() && st.peek() < num){
                    st.push(idx++);
                    sb.append("+").append("\n");
                }else if(!st.isEmpty() && st.peek() == num){
                    st.pop();
                    sb.append("-").append("\n");
                    flag = false;
                }else if(st.isEmpty()){
                    sb.append("+").append("\n");
                    st.push(idx++);
                }else{
                    System.out.println("NO");
                    return;
                }

                if(idx > N+1 && !st.isEmpty()){
                    System.out.println("NO");
                    return;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
