import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, cnt, min;
    static int[][] map, list;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][M];
        list = new int[K][3];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<K; i++) {
            list[i][0] = sc.nextInt(); // r
            list[i][1] = sc.nextInt(); // c
            list[i][2] = sc.nextInt(); // s
            // r-s, c-s     r+s, c+s
        }

        cnt = 0;
        min = Integer.MAX_VALUE;
        int[] arr = new int[K];
        boolean[] visited = new boolean[K];

        // permutation 함수 돌리고 => 순열함수 다채워지면 그걸로 doCycle 돌려서 min값 찾고 비교해서 min값 최신화
        // 마지막에 최종 min 값을 출력하면 됨
        permutation(0, arr, visited);

        System.out.println(min);

    }

    public static void permutation (int cnt, int[] arr, boolean[] visited) {
        if (cnt == K) {
            // 순서정해서 arr 채웠으면 그걸로 회전 돌릴 함수
//			for (int i=0; i<K; i++) {
//				System.out.print(arr[i]+" ");
//			}
//			System.out.println();
            doCycle(arr);
            return;
        }

        for (int i=0; i<K; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i; // 어떤 순서인지가 arr에 배열로 담기는거임
            permutation(cnt+1, arr, visited);
            visited[i] = false;
        }
    }

    public static void doCycle (int[] arr) {
        // 깊은복사로 맵 하나 더만들기
        int[][] tmpMap = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }

        for (int i=0; i<K; i++) {
            int r = list[arr[i]][0]-1;
            int c = list[arr[i]][1]-1;
            int s = list[arr[i]][2];
//			System.out.println(r+" "+c+" "+s);

//			System.out.println("처음 배열@@@");
//			for (int a=0; a<N; a++) {
//				for (int b=0; b<M; b++) {
//					System.out.print(tmpMap[a][b]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("처음 배열@@@");

            // s를 하나씩 키워가면서 한바퀴씩 돌거임 => ss로 쓰자
            for (int ss=1; ss<=s; ss++) {
                // 네 귀퉁이 temp로 저장하면서 걍 돌리면 됨
                //  x   tmp1
                // tmp3 tmp2

                // 위 => y 하나씩 감소
                int tmp1 = tmpMap[r-ss][c+ss];
                for (int y=c+ss; y>c-ss; y--) {
                    tmpMap[r-ss][y] = tmpMap[r-ss][y-1];
                }

                // 오른쪽 => x 하나씩 감소
                int tmp2 = tmpMap[r+ss][c+ss];
                for (int x=r+ss; x>r-ss; x--) {
                    tmpMap[x][c+ss] = tmpMap[x-1][c+ss];
                }
                tmpMap[r-ss+1][c+ss] = tmp1;

                // 아래 => y 하나씩 증가
                int tmp3 = tmpMap[r+ss][c-ss];
                for (int y=c-ss; y<c+ss; y++) {
                    tmpMap[r+ss][y] = tmpMap[r+ss][y+1];
                }
                tmpMap[r+ss][c+ss-1] = tmp2;

                // 왼쪽 => x 하나씩 증가
                for (int x=r-ss; x<r+ss; x++) {
                    tmpMap[x][c-ss] = tmpMap[x+1][c-ss];
                }
                tmpMap[r+ss-1][c-ss] = tmp3;
            }
//			for (int a=0; a<N; a++) {
//				for (int b=0; b<M; b++) {
//					System.out.print(tmpMap[a][b]+" ");
//				}
//				System.out.println();
//			}
//            System.out.println();
        }


        // 회전 다 돌린 후 min값 추출
        for (int i=0; i<N; i++) {
            int sum = 0;
            for (int j=0; j<M; j++) {
                sum += tmpMap[i][j];
            }
            if (min > sum) {
                min = sum;


//				for (int a=0; a<K; a++) {
//					System.out.print(arr[a]+" ");
//				}
//				System.out.println();
            }
        }

    }
}