import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B16973_직사각형탈출_김지승 {

	private static int N;
	private static int M;
	private static int[][] square;
	private static int H;  //직사각형 높이 
	private static int W;  //직사각형 너비 
	private static int SR; //시작 행    
	private static int SC; //시작 열    
	private static int FR; //목표 행    
	private static int FC; //목표 열    
	private static boolean[][] visited;
	private static int[][] distance;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("B16973_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		square = new int[N+1][M+1];
		distance = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				square [i][j]= Integer.parseInt(st.nextToken());
			}
			
		}
		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		SR = Integer.parseInt(st.nextToken());	
		SC = Integer.parseInt(st.nextToken());
		FR = Integer.parseInt(st.nextToken());
		FC = Integer.parseInt(st.nextToken());
		
		bfs(SR,SC);
		
		System.out.println(dis);
	}
	private static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	private static int dis;
	private static void bfs(int startR, int startC) {
		visited[startR][startC] = true;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {startR,startC});
		dis = 0;
		distance[startR][startC] = 0;
		
re:		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nr = current[0] + dir[i][0];
				int nc = current[1] + dir[i][1];
				if(nr>=1 && nr<=N && nc>=1 && nc<=M
						&& !visited[nr][nc]) {
						visited[nr][nc] = true;
					if(square[nr][nc]==0) { //사각형의 왼쪽위가 갈 수 있는 곳이라면.
						if(check(nr,nc)) { //사각형 범위가 모두 0인지 체크
							distance[nr][nc] = distance[current[0]][current[1]]+1;
							//갈 수 있는데 도착점이면!!'ㅅ'?ㅎㅁㅎ?!
							if(nr==FR && nc==FC) {
								dis = distance[nr][nc];
								return;
							}
							//갈 수 있으면 queue에 넣음.
							queue.offer(new int[] {nr,nc});
						}else {
							if(nr==FR && nc==FC) {
								break re;
							}
						}
					}
				}
			}// end of for
		}// end of while
		dis = -1;
		return;
	}
	private static boolean check(int nr, int nc) {
		for (int r = nr; r < nr + H; r++) {
			for (int c = nc; c < nc + W; c++) {
				if(r<1 || r>N || c<1 || c>M) return false; //범위 밖이거나
				if(square[r][c]==1) return false; //1이 존재하면 return false;
			}
		}
		return true;
	}

}
