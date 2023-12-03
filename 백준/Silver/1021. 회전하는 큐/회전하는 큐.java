
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    
    static int N;
    static int M;
    static int ans;
    static Deque<Integer> dq2;
    static Deque<Integer> dq3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        ans = 0;

        dq2 = new ArrayDeque<>();
        dq3 = new ArrayDeque<>();

        // 디큐 넣기
        for(int i=1; i<=N; i++){
            dq2.addFirst(i);
            dq3.addFirst(i);
        }

        // 입력
        for(int i=0; i<M; i++){
            int input = sc.nextInt();

            int left = 0;
            int right = 0;

            // 왼쪽 카운트
            while (!dq2.isEmpty()){
                if(input == dq2.peekLast()){
                    dq2.removeLast();
                    break;
                }else{
                    op2();
                    left++;
                }
            }

            // 오른쪽 카운트
            while (!dq3.isEmpty()){
                if(input == dq3.peekLast()){
                    dq3.removeLast();
                    break;
                }else{
                    op3();
                    right++;
                }
            }

            // 작은쪽을 ans에 추가하고
            // 없애기

            if(left<right){
                ans+=left;
            }else{
                ans+=right;
            }
        }

        System.out.println(ans);
    }
    
    // 왼쪽 이동
    public static void op2(){
        int n = dq2.removeLast();
        dq2.addFirst(n);
    }
    
    // 오른쪽 이동
    public static void op3(){
        int n = dq3.removeFirst();
        dq3.addLast(n);
    }
    
}
