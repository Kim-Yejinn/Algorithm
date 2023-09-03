
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int ans;
    static int[][] arr;
    static int[] sel;
    public static class Node{
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        ans = Integer.MAX_VALUE;
        //집
        List<Node> house = new ArrayList<>();
        // 치킨
        List<Node> chicken = new ArrayList<>();

        sel = new int[M];

        for(int r =0; r<N; r++){
            for(int c= 0; c<N; c++){
                int t = sc.nextInt();

                if(t == 1){
                    //집
                    house.add(new Node(r,c));
                }else if(t==2){
                    // 치킨
                    chicken.add(new Node(r,c));
                }
            }
        }

        arr = new int[house.size()][chicken.size()];

        for(int i=0; i<chicken.size(); i++){
            Node c = chicken.get(i);

            for(int j=0; j<house.size(); j++){
                Node h = house.get(j);

                // 치킨 거리
                arr[j][i]=Math.abs(h.r-c.r) + Math.abs(h.c-c.c);
            }
        }

        rec(0,0);
        System.out.println(ans);
    }
    public static void rec(int num,int st){
        //M개 치킨집 고르기
        if(num == M){
            sum();
            return;
        }

        for(int i=st; i<arr[0].length; i++){
            sel[num]= i;
            rec(num + 1, i+1);
        }
    }
    public static void sum(){
        int sum = 0;
        //house
        for(int i=0; i<arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<M; j++){
               //chicken
                if(arr[i][sel[j]] < min){
                    min = arr[i][sel[j]];
                }
            }
            sum +=min;
        }
        if(sum<ans){
            ans = sum;
        }
    }
}
