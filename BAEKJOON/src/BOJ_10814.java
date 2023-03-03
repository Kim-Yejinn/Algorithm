import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_10814 {
	static class person {
		int num;
		int age;
		String name;

		person(int num, int age, String name) {
			this.num = num;
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		PriorityQueue<person> pq = new PriorityQueue<>(new Comparator<person>() {

			@Override
			public int compare(person o1, person o2) {
				if (o1.age != o2.age) {
					return o1.age - o2.age;
				} else {
					return o1.num - o2.num;
				}
			}
		});
		for (int i = 0; i < N; i++) {
			pq.offer(new person(i, sc.nextInt(), sc.next()));

		}

		for (int i = 0; i < N; i++) {
			System.out.println(pq.poll());

		}

	}
}
