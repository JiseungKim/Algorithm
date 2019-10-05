import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Baekjoon_9205_맥주마시면서걸어가기_김지승 {
	private static int totalPoint;
	private static int[][] location;
	static boolean visited[];
	static class Points {
		int x;
		int y;
		public Points(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public static int distance(Points p1,Points p2) {
			return Math.abs(p1.x-p2.x)+ Math.abs(p1.y-p2.y); 
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int con = Integer.parseInt(br.readLine());
			totalPoint = con+2;
			location = new int[totalPoint][totalPoint];
			Points[] points_array = new Points[totalPoint];
			visited = new boolean[totalPoint]; //방문 체크
			
			for (int point = 0; point < totalPoint; point++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points_array[point] = new Points(x,y);
			}
			
			//인근 접점 표시
			for (int r = 0; r < con+2; r++) {
				for (int c = 0; c < con+2; c++) {
					if(r==c) continue;
					int distance = Points.distance(points_array[r],points_array[c]);
					if(distance>1000) continue;
					else location[r][c] = 1;
				}
			}
			//인근 접점 검사
//			for (int[] ar1: location) {
//				for (int ar2 : ar1) {
//					System.out.print(ar2+" ");
//				}
//				System.out.println();
//			}
			bfs(0);
		}
	}
	
	public static void bfs(int start) {
		boolean[] visited = new boolean[totalPoint]; //정점 수 만큼.
		//정점 번호르 넣을 곳.
		Queue<Integer> queue = new LinkedList<Integer>(); //linkedlist는 queue도 구현함
		//참조타입->큐  - LinkedList에서 Queue에 정의된 메서드만 사용 가능.
		
		//queue의 시작점.
		visited[start] = true; //현재 지점 방문.
		queue.offer(start); //enqueue함.
		
		//큐가 비어있지 않으면
		while(!queue.isEmpty()) {
			int current = queue.poll(); //dequeue
			for (int i = 0; i < totalPoint; i++) {
				//인접해있고, 방문하지 않은 곳 방문.
				if(location[current][i]==1 && !visited[i]) {
					//방문한곳 찜하기
					visited[i] = true;
//					System.out.print(i+" "); //방문한 곳
					//queue에 넣기.
					queue.offer(i);
				}
			}
		}
		if(visited[totalPoint-1]==true) System.out.println("happy");
		else System.out.println("sad");
	}

}
