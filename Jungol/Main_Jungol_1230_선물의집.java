import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Jungol_1230_선물의집 {
	static int N; 
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0] =true;
		if(map[0][0]==2) dfs(0,0,1);
		else dfs(0,0,0);
		System.out.println(MAX);
		
		
	}
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static boolean visited[][];
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static int MAX = 0;
	
	private static void dfs(int currentR, int currentC, int gift) {
		if(currentR==N-1 && currentC==N-1 && MAX<gift) MAX = gift;

		for (int k = 0; k < 4; k++) {
			int newR = currentR + dir[k][0];
			int newC = currentC + dir[k][1];
			
			if(newR>=0 && newR<N && newC>=0 && newC<N) {
				if(!visited[newR][newC]) {
					if( map[newR][newC]!=1) {
						visited[newR][newC] = true;
						if(map[newR][newC]==2)
							dfs(newR,newC,gift+1);
						else dfs(newR,newC,gift);
						visited[newR][newC] = false;

					}
				}
			}
		}		
	}
}