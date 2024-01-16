import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] list = new long[K];

//        long left = 0;
//        long right = 0;

        for (int i=0; i<K; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);

        long left = 1;
        long right = list[K-1]+1;


        while (left < right) {
            long mid = (left+right)/2;
//            System.out.print(left+" "+mid+" "+right);

            long cnt = 0;
            for (int i=0; i<K; i++) {
                cnt += (list[i]/mid);
            }
//            System.out.println(" // "+cnt);

            if (cnt < N) { // 더 잘게 잘랐음.. 길이 늘려도됨
                right = mid;
            } else {
                left = mid+1;
            }
        }

        System.out.println(left-1);
    }
}