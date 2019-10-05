import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BaekJoon_1012_유기농배추_김지승 {
	static int M;
	static int N;
	static int[][] ground;
	static int[][] dir = {
			{0,1},{1,0},{-1,0},{0,-1}	
		};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			ground = new int[N][M];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				ground[r][c] = 1;
			}
			System.out.println(wormCount());
		}
	}

	private static int wormCount() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] point;// = new int[2];
		int worm = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				//배추 발견.
				if(ground[r][c]==1) {
					//방문 체크. -> 2
					ground[r][c] = 2;
					point = new int[2];
					point[0] = r;
					point[1] = c;
					//queue에 저장.
					queue.offer(point);
					
					while(!queue.isEmpty()) {
						int[] current = queue.poll();
						int curR = current[0];
						int curC = current[1];
						for (int i = 0; i < 4; i++) {
							int newR = curR + dir[i][0];
							int newC = curC + dir[i][1];
							if(inGround(newR,newC)
									&& ground[newR][newC]==1) {
								//방문지점 표시
								ground[newR][newC] = 2;
								int[] newBaechoo = {newR,newC};
								queue.offer(newBaechoo);
								
							}
						}
					}
                    worm++;
				}
			}
		}
		return worm;
	}
	private static boolean inGround(int r,int c) {
		if(r>=0 && r<N && c>=0 && c<M) return true;
		return false;
	}

}
