
import java.util.Scanner;
// 1시간

// 1. 겹치는 것 주의
// 2. abs로 할경우 3-2 1-2 같다고 할수도..
// 3. 경사 올라가는 것/ 내려 가는 것 다름


public class Main {
    static int[][] map;
    static int N;
    static int L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // map
        N = sc.nextInt();
        map = new int[N][N];

        // 경사로 길이
        L = sc.nextInt();

        // 입력
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        // 돌면서 확인
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            // 가로 확인
            if (check_row(i)) {
                cnt++;
            }
            // 세로 확인
            if (check_col(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    // 가능 여부 반환
    public static boolean check_row(int st) {
        boolean result = true;

        int last = map[st][0];

        // T : 경사로 F : 경사로 아님
        boolean status = false;
        // 앞으로 갈 곳중 가능한 칸
        int count_up = 0;
        // 지나온 것 중 가능한 칸
        int count_down = 1;

        for (int i = 1; i < N; i++) {
            // 경사로 카운트 x
            if (!status) {
                if (last == map[st][i]) {
                    // 만약 같으면
                    count_down++;
                } else if (last - map[st][i] == 1) {
                    // 만약 층수가 다른데 1개면
                    // 낮은 쪽으로 갈때
                    status = true;
                    last = map[st][i];
                    count_up = 1;
                    count_down = 0;

                    // 만약 L == 1일 경우
                    if (count_up == L) {
                        count_up = 0;
                        status = false;
                    }
                } else if (map[st][i] - last == 1) {
                    // 1칸 차이고
                    // 높은곳으로 갈때
                    if (count_down >= L) {
                        last = map[st][i];
                        count_down = 1;
                    } else {
                        return false;
                    }
                } else {
                    // 층수 두개 이상
                    return false;
                }
            } else {
                // 경사로 카운트
                if (last == map[st][i]) {
                    count_up++;
                    last = map[st][i];

                    if (count_up == L) {
                        count_up = 0;
                        count_down = 0;
                        status = false;
                    }
                } else {
                    return false;
                }
            }
        }
        // 아직 경사로 설치중일 수도 있으니
        if (count_up == 0) {
            return result;
        } else {
            return false;
        }

    }

    public static boolean check_col(int st) {
        boolean result = true;

        int last = map[0][st];

        // T : 경사로 F : 경사로 아님
        boolean status = false;
        int count_up = 0;
        int count_down = 1;

        for (int i = 1; i < N; i++) {
            // 경사로 카운트 x
            if (!status) {
                if (last == map[i][st]) {
                    // 만약 같으면
                    count_down++;
                } else if (last - map[i][st] == 1) {
                    // 만약 층수가 다른데 1개면
                    // 낮은 쪽으로 갈때
                    status = true;
                    last = map[i][st];
                    count_up = 1;
                    count_down = 0;

                    // 만약 L == 1일 경우
                    if (count_up == L) {
                        count_up = 0;
                        status = false;
                    }
                } else if (map[i][st] - last == 1) {
                    // 1칸 차이고
                    // 높은곳으로 갈때
                    if (count_down >= L) {
                        last = map[i][st];
                        count_down = 1;
                    } else {
                        return false;
                    }
                } else {
                    // 층수 두개 이상
                    return false;
                }
            } else {
                // 경사로 카운트
                if (last == map[i][st]) {
                    count_up++;
                    last = map[i][st];

                    if (count_up == L) {
                        count_up = 0;
                        count_down = 0;
                        status = false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (count_up == 0) {
            return result;
        } else {
            return false;
        }

    }
}