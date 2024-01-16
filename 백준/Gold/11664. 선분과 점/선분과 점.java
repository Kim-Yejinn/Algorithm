import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int az = sc.nextInt();

        int bx = sc.nextInt();
        int by = sc.nextInt();
        int bz = sc.nextInt();

        int cx = sc.nextInt();
        int cy = sc.nextInt();
        int cz = sc.nextInt();

        // 벡터 cb
        long cbx = bx-cx;
        long cby = by-cy;
        long cbz = bz-cz;

        // 벡터 ca
        long cax = ax-cx;
        long cay = ay-cy;
        long caz = az-cz;


        // 벡터 cb ca -> ab
        long abx = bx-ax;
        long aby = by-ay;
        long abz = bz-az;


        // 내적
        // ab ca
        double dotProduct1 = abx*(-cax)+aby*(-cay)+abz*(-caz);
        // ba bc
        double dotProduct2 = cbx*abx+cby*aby+cbz*abz;

        // 외적 크기
        double crossProduct = Math.sqrt((cby*caz-cbz*cay)*(cby*caz-cbz*cay) + (cbx*caz-cbz*cax)*(cbx*caz-cbz*cax) + (cbx*cay-cby*cax)*(cbx*cay-cby*cax));
        // 길이
        double ca = Math.sqrt(cax*cax + cay*cay + caz*caz);
        double cb = Math.sqrt(cbx*cbx + cby*cby + cbz*cbz);
        double ab = Math.sqrt(abx*abx + aby*aby + abz*abz);

        double ans = Math.min(ca, cb);

        if(dotProduct1>=0 && dotProduct2 >= 0){
            // 수선의 발 내릴 수 있을때
            // 외적으로 넓이 구하고 길이 구하면 됨.
            ans = Math.min(ans, crossProduct/ab);
        }
        System.out.printf("%.10f", ans);

    }
}