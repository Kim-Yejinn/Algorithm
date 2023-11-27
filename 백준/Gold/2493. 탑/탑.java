
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        Stack<Node> stack =  new Stack<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                stack.push(new Node(i, num));
                System.out.print("0 ");
            }else{
                while (!stack.isEmpty()){
                    Node last = stack.peek();
                    if(last.height<num){
                        stack.pop();
                    }else{
                        System.out.print((last.idx+1)+" ");
                        break;
                    }
                }
                if(stack.isEmpty()){
                    System.out.print("0 ");
                }
                stack.push(new Node(i, num));
            }
        }
    }
}
