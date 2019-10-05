import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Baekjoon_14503_로봇청소기_김지승 {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int dir[][] = {
				//북		동	      남           서
				{-1,0},{0,1},{1,0},{0,-1}
		};
//		boolean[][] checked = new boolean[N][M];
		int[][] place = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		//배열에 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int total = 1; 
		int new_r = r;
		int new_c = c;
		w:
		while(true) {
			//방문체크, 청소.
			place[new_r][new_c] = 8;
//			total++;
			//왼쪽 방향 체크,,
			int left_r = new_r + dir[d-1<0?3:d-1][0];
			int left_c = new_c + dir[d-1<0?3:d-1][1];
			// 왼쪽이 경계 안이며 방문한 적 없고, 벽이 아니라면
			if(place[left_r][left_c]==0) {
//				왼쪽 방향으로 회전한 뒤 이동.
				d = d-1<0?3:d-1;
				new_r = left_r;
				new_c = left_c;
				total++; //이동하면 청소.
			}else{ //경계 밖이거나, 방문한 적 있거나, 벽이라면.
				for (int i = 0; i < 3; i++) {
				// 왼쪽으로 회전한 뒤, 왼쪽 체크
					d = d-1<0?3:d-1;
					int ttr = new_r + dir[d-1<0?3:d-1][0];
					int ttc = new_c + dir[d-1<0?3:d-1][1];
//					
//					왼쪽이 방문한 적 없으며 벽이 아니면 이동.
					if(place[ttr][ttc]==0) {
						d = d-1<0?3:d-1;
						new_r = ttr;
						new_c = ttc;
						total++; //이동하면 청소.
						continue w;
					
					}
				}
				d = d-1<0?3:d-1;
				//for문을 다 돌았으므로, 네 방향이 다 벽이거나 청소한 상태이므로 후진
				//후진할 위치.
				int tr = new_r + dir[(d+2)%4][0];
				int tc = new_c + dir[(d+2)%4][1];
				//후진할 위치가 벽이면, 작동 중지.
				if(place[tr][tc]==1) break w;
				//벽이 아니라면, 방향을 바꾸지 않고 이동하는데,
				//청소는 이미 했으므로 청소X (count++하지않음)
				else {
					new_r = tr;
					new_c = tc;
				}
				
			}
		}
		/* 청소 결과 찍기 */
//		for (int[] is : place) {
//			for (int is2 : is) {
//				System.out.print(is2+" ");
//			}
//			System.out.println();
//		}
		System.out.println(total);
	}

}