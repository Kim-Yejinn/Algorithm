
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int idx;
        int height;
        Node(int idx, int height){
            this.idx= idx;
            this.height = height;
        }
    }


    // BufferedReader를 사용할 경우 메모리, 시간 측면에서 이득(메모리 초과 해결)
    // BufferedWriter를 사용할 경우에도 시간 이득( 3400ms -> 724ms)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Stack<Node> stack =  new Stack<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                stack.push(new Node(i, num));
                sb.append("0 ");
            }else{
                while (!stack.isEmpty()){
                    Node last = stack.peek();
                    if(last.height<num){
                        stack.pop();
                    }else{
                        sb.append((last.idx+1)+" ");
                        break;
                    }
                }
                if(stack.isEmpty()){
                    sb.append("0 ");
                }
                stack.push(new Node(i, num));
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
