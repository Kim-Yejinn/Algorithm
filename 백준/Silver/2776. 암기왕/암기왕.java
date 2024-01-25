import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int N = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++){
                set.add(sc.nextInt());
            }

            int M = sc.nextInt();

            for(int i=0; i<M; i++){
                int num = sc.nextInt();
                if(set.contains(num)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
            System.out.print(sb);
        }
    }
}