import java.util.Scanner;

public class SWEA_2056_연월일달력 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int year;
		int month;
		int day;

		start: for (int i = 1; i <= T; i++) {
			String ymd = sc.next();

			year = Integer.parseInt(ymd.substring(0, 4));
			month = Integer.parseInt(ymd.substring(4, 6));
			day = Integer.parseInt(ymd.substring(6, 8));

			if (year < 0) {
				System.out.println("#" + i + " " + -1);
				continue start;
			}
			if (month <= 0 | month > 13) {
				System.out.println("#" + i + " " + -1);
				continue start;
			}
			if (day <= 0) {
				System.out.println("#" + i + " " + -1);
				continue start;
			}

			switch (month) {
			case 1:	case 3:	case 5:	case 7:	case 8:	case 10:case 12:
				if (day > 31) {
					System.out.println("#" + i + " " + -1);
					continue start;
				}
				break;
			case 4:	case 6:	case 9:	case 11:
				if (day > 30) {
					System.out.println("#" + i + " " + -1);
					continue start;
				}
				break;
			case 2:
				if (day > 28) {
					System.out.println("#" + i + " " + -1);
					continue start;
				}
				break;
			}
			System.out.printf("#%d %04d/%02d/%02d\n", i, year, month, day);

		}

	}

}
