import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int today_year = Integer.parseInt(st.nextToken());
        int today_month = Integer.parseInt(st.nextToken());
        int today_day = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int d_year = Integer.parseInt(st.nextToken());
        int d_month = Integer.parseInt(st.nextToken());
        int d_day = Integer.parseInt(st.nextToken());

        if(d_year > today_year+1000 || (d_year == today_year+1000 && d_month > today_month) || (d_year == today_year + 1000 && today_month == d_month && d_day >= today_day)){
            System.out.println("gg");
            return;
        }


        int[] t_day = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 365
        int[] f_day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 366

        int cal = 0;

        for(int i=today_year; i<d_year; i++){
            if(check(i)){
                cal += 366;
            }else{
                cal += 365;
            }
        }

        for(int i=1; i<d_month; i++) {
            if (check(d_year)) {
                cal += t_day[i];
            } else {
                cal += f_day[i];
            }
        }
        for(int i=1; i<=today_month; i++){
            if(check(today_year)){
                cal -= t_day[i];
            }else{
                cal -= f_day[i];
            }
        }
        cal += d_day;

        if(check(today_year)){
            cal += t_day[today_month] - today_day;
        }else{
            cal += f_day[today_month] - today_day;
        }
        System.out.println("D-"+cal);
    }
    public static boolean check(int year){
        if(year % 400 == 0){
            return true;
        }
        if(year % 100 == 0){
            return false;
        }
        if(year % 4 == 0){
            return true;
        }
        return false;
    }
}
