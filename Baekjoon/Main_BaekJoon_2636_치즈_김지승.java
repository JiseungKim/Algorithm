package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BaekJoon_2636_치즈_김지승 {
	public static class Point{
		int r;
		int c;
		public Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int sero = Integer.parseInt(st.nextToken());
		int garo = Integer.parseInt(st.nextToken());
		int time = 0; 				//치즈가 다 녹을 때 까지 걸리는 시간.
		int last_cheese = 0; 		//남은 치즈 갯수
		int last_cheese_keep = 0; 	//다 녹기 전 남은 치즈 갯수 저장.
		int[][] cheese = new int[sero][garo];
		for (int r = 0; r < sero; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < garo; c++) {
				int temp = Integer.parseInt(st.nextToken());
				cheese[r][c] = temp;
				if(temp==1) last_cheese++;
				
			}
		}
		last_cheese_keep = last_cheese;
		boolean[][] outVisited;
		boolean[][] willRemove;
		while(last_cheese>0) {
			//바깥 부분 표시.
			Queue<Point> outQueue = new LinkedList<Point>();
			outVisited = new boolean[sero][garo];	//바깥 체크
			willRemove = new boolean[sero][garo];	//녹을 치즈
			outVisited[0][0] = true;
			outQueue.offer(new Point(0,0));
			
			while(!outQueue.isEmpty()) {
				Point currentPoint = outQueue.poll();
				
				for (int i = 0; i < 4; i++) {
					int newR = currentPoint.r + dir[i][0];
					int newC = currentPoint.c + dir[i][1];
					
					if(newR>=0 && newR<sero && newC>=0 && newC<garo) {
						//방문한 적 없고, 치즈가 0이면.
						if(!outVisited[newR][newC]) {
							if(cheese[newR][newC]==0) {
								outVisited[newR][newC] = true;
								outQueue.offer(new Point(newR,newC));
							}else {
								//바깥 쪽에서 1을 마주하면, 녹을 치즈임을 표시
								willRemove[newR][newC] = true;
							}
						}
						
					}
				}
			}
			//바깥쪽을 다 체크한 후, 녹을예정일 치즈 녹는다.
			for (int r = 0; r < sero; r++) {
				for (int c = 0; c < garo; c++) {
					if(willRemove[r][c]) {
						cheese[r][c] = 0;
						last_cheese--;
					}
				}
			}
			//1시간 지남.
			time++;
			//다 녹기 전 갯수 저장.
			if(last_cheese!=0) last_cheese_keep = last_cheese;
		}

		System.out.println(time);
		System.out.println(last_cheese_keep);
	}

	
}
