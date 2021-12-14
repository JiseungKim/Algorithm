package SWEA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1249_보급로_김지승 {
	static class Loc{
		int r;
		int c;
		public Loc(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	private static int[][] map;
	private static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	private static int N;
	private static int[][] minmap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			sc.nextLine();
			map = new int[N][N];
			minmap = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(minmap[i], Integer.MAX_VALUE);
			}
			minmap[0][0] = 0;
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			bfs();
			
			System.out.println("#"+tc+" "+minmap[N-1][N-1]);
		}
	}
	private static void bfs() {
		Queue<Loc> queue = new LinkedList<Loc>();
		queue.offer(new Loc(0,0));
		while(!queue.isEmpty()) {
			Loc cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r+dir[i][0];
				int nc = cur.c+dir[i][1];
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					int newD = minmap[cur.r][cur.c] + map[nr][nc]; //다음최소깊이 : 현재최소깊이 + 다음 깊이 
					if(newD < minmap[nr][nc]) {
						minmap[nr][nc] = newD;
						queue.offer(new Loc(nr,nc));
					}
				}
			}
		}
	}

}
