import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BaekJoon_2178_미로탐색_김지승 {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
//		for (int[] ints : map) {
//			System.out.println(Arrays.toString(ints));
//		}
	}
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	
	private static void bfs(int startR, int startC) {
		visited[startR][startC] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] start = {startR,startC};
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentR = current[0];
			int currentC = current[1];
			
			for (int i = 0; i < 4; i++) {//
				int newR = currentR+dir[i][0];
				int newC = currentC+dir[i][1];
				if(newR>=0 && newR<N && newC>=0 && newC<M
						&& map[newR][newC]==1 && !visited[newR][newC]) {
					//상하좌우 탐색 전 위치! 저장
					map[newR][newC] = map[currentR][currentC]+1;
					int[] newCurrent = {newR,newC};
					queue.offer(newCurrent);
				}
			}//end for
		}
	}

}
