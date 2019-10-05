import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B2567_색종이2 {
	
	public static class Point{
		int x;
		int y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] paper;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		paper = new int[102][102];
		visited = new boolean[102][102];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())+1;
			int y = Integer.parseInt(st.nextToken())+1;
			for (int k = x; k < x+10; k++) {
				for (int l = y; l < y+10; l++) {
					paper[k][l] = 1;
				}
			}
		}
		dfs();
		System.out.println(doole);
	}
	static int doole;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static boolean[][] visited;
	private static void dfs() {
		doole = 0;
		Queue<Point> queue = new LinkedList<Point>();
		for (int r = 0; r < 102; r++) {
			for (int c = 0; c < 102; c++) {
				if(paper[r][c]==1  && !visited[r][c]) {
					queue.offer(new Point(r,c));
					while(!queue.isEmpty()) {
						Point current = queue.poll();
						visited[current.x][current.y]= true; 
						for (int i = 0; i < 4; i++) {
							int newX = current.x + dir[i][0];
							int newY = current.y + dir[i][1];
							if(newX>=0 && newX<102 && newY>=0 && newY<102) {
								if(paper[newX][newY]==1 && !visited[newX][newY]) {
									visited[newX][newY]=true;
									queue.offer(new Point(newX,newY));
								}else if(paper[newX][newY]==0) doole++;
							}
						}
					}
					
					
				}
			}//for
		}
	}

}
