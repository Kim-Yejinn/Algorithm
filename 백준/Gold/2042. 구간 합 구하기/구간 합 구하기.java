import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] A; // 입력이 들어가 있는 배열
    static long[] bucket; // 구간 합을 저장해 두는 곳

    static int N;
    static int size; // 루트 N의 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        A = new long[N];
        size = (int) Math.sqrt(N);
        bucket = new long[N/size + 1];

        for(int i=0; i<N; i++){
            long num = Long.parseLong(br.readLine());
            // 입력
            A[i] = num;
            // 합을 나눠서 넣어준다
            bucket[i/size] += A[i];
        }
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if(a == 1){
                int b = Integer.parseInt(st.nextToken())-1;
                long c = Long.parseLong(st.nextToken());
                update(b, c);
            }else{
                int b = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken())-1;
                System.out.println(query(b, c));
            }
        }

    }
    public static void update(int pos, long val){
        // pos에 val을 바꾸어야 한다.
        // 원래 값과, 갱신해야 하는 값의 차이를 계산한다.
        long diff = val - A[pos];

        // 해당 위치의 값을 변경한다
        A[pos] = val;

        // 기존 원소의 묶음에 갱신으로 인한 차이를 반영해 준다
        bucket[pos/size] += diff;
    }
    public static long query(int low, int high){
        long ret = 0;
        
        // 구간이 맞아 떨어지지 않으면
        // 왼쪽 걸쳐 있는 부분 더해주기
        while (low%size!=0 && low <= high){
            ret += A[low++];
        }

        // 오른족 걸친 것들 더해주기 (오른쪽은 1 더해주고 계산해야 함. (끝부분이 배수 -1))
        while ((high+1) % size!=0 && low<=high){
            ret += A[high--];
        }
        // 구간 맞아 떨아질 때 -> 미리 계산해 둔 값을 더해 준다
        while (low <= high){
            ret += bucket[low / size];
            low += size;
        }
        return ret;
    }
}