import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();

        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            set.add(sc.nextInt());
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int num = sc.nextInt();
            if(set.contains(num)){
                sb.append("1 ");
            }else{
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }
}