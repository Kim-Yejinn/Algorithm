
import java.io.*;

public class Main {

    static int rear;
    static int front;
    static int[] queue;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        init();

        for(int tc = 0; tc<N; tc++){
            String[] str = br.readLine().split(" ");

            if(str[0].equals("push")){
                push(Integer.parseInt(str[1]));
            }else if(str[0].equals("pop")){
                bw.write(pop()+"\n");
            }else if(str[0].equals("size")){
                bw.write(size()+"\n");
            }else if(str[0].equals("empty")){
                bw.write(empty()+"\n");
            }else if(str[0].equals("front")){
                bw.write(front()+"\n");
            }else if(str[0].equals("back")){
                bw.write(back()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void init(){
        rear = 0;
        front = 0;
        queue = new int[N];
    }

    public static void push(int num){
        queue[rear++] = num;
    }
    public static int pop(){
        if(empty() == 1){
            return -1;
        }else{
            return queue[front++];
        }
    }
    public static int size(){
        return rear-front;
    }

    public static int empty(){
        if(front == rear){
            return 1;
        }else{
            return 0;
        }
    }
    public static int front(){
        if(empty() == 1){
            return -1;
        }else{
            return queue[front];
        }
    }
    public static int back(){
        if(empty() == 1){
            return -1;
        }else {
            return queue[rear-1];
        }
    }

}
