import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B8983_사냥꾼_김지승 {
	/*배열로 바꾸기*/
	private static int M; // 사대
	private static int N; // 동물
	private static int L;
	public static class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			return x-o.x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //동물
		L = Integer.parseInt(st.nextToken());
		int[] hunters = new int[M];
		Point[] animals = new Point[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			hunters[i] = tmp;
		}
		//동물 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animals[i] = new Point(x,y);
		}
		Arrays.sort(hunters);
		int count = 0;
		for (Point animal : animals) {
			if(animal.y > L) continue;
			int index = Arrays.binarySearch(hunters, animal.x);
			if(index>=0) count++;
			else {
				//음수일 경우에는 양쪽 인덱스 검사.
				/*
				 *    0   1   2   3  
				 * -1  -2  -3  -4   -5
				 */
				index = Math.abs(index);
				if((index -2 > -1 && Math.abs(hunters[index-2]-animal.x)+animal.y<=L )
						|| ( index -1 < M && Math.abs(hunters[index-1]-animal.x)+animal.y<=L)) count++; 
			}
		}
		
		System.out.println(Math.abs(count));
	}

}
