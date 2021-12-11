import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기_김지승 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int test_case = sc.nextInt();
			
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				int n = sc.nextInt();
				queue.offer(n);
			}
			
//			사이클 시작
			total:
			while(true) {
				for (int i = 1; i<=5/*0숫자가 0보다 작아지는 경우에 0으로 유지되며 프로그램 종료.*/; i++) {
					if(queue.peek()-i<=0) {
						queue.poll();
						queue.offer(0);
						break total;
					}
					int m = queue.poll();
					m = m - i; 
					queue.offer(m);
				}
			}
			StringBuilder sb = new StringBuilder();
			for (Integer integer : queue) {
				sb.append(integer+" ");
			}
			System.out.println("#"+test_case+" "+sb);
		}
	}

}
