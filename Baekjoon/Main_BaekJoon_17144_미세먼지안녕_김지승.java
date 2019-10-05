import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BaekJoon_17144_미세먼지안녕_김지승 {
	static int[][] room;
	static int[][] dirtyRoom;
	private static int C;
	private static int R;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());	// 1 <= T <= 1000
		
		room = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			clear();
		}

		//미세먼지 양 구하기.
		int sum = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sum+= room[r][c];
			}
		}
		System.out.println(sum+2);
	}
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	private static void clear() {
		//1초동안 일어나는 일.
		dirtyRoom = new int[R][C];
		//미세먼지 확산(미세먼지가 있는 모든 칸에서 동시에)
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(room[r][c]>0) {
					int munjiCount = 0;
					int munji = 0;
					for (int i = 0; i < dir.length; i++) {
						int newR = r + dir[i][0];
						int newC = c + dir[i][1];
						munji = room[r][c]/5;
						if(newR>=0 && newR<R && newC>=0 && newC<C 
								&& room[newR][newC]>=0) {//공기청정기 없어야 함.
							dirtyRoom[newR][newC]+=munji;
							munjiCount++;
						}
					}
					dirtyRoom[r][c] += room[r][c] - (munji * munjiCount);
				}
			}
		}
		
		
		//공기청정기 작동
		//공기청정기 찾기
		int clearR1 = 0;
		int clearR2 = 0;
		for (int r = 0; r < R; r++) {
			if(room[r][0]==-1) {
				clearR1 = r;
				clearR2 = r+1;
				break;
			}
		}
		
		//반시계방향 청소기 가동
		for (int r = clearR1; r-1 >=0 ; r--) {	//하
			dirtyRoom[r][0] = dirtyRoom[r-1][0];
		}
		for (int c = 1; c < C; c++) {			//좌
			dirtyRoom[0][c-1] = dirtyRoom[0][c];
		}
		for (int r = 1; r <=clearR1 ; r++) {	//우
			dirtyRoom[r-1][C-1] = dirtyRoom[r][C-1];
		}
		for (int c = C-2; c >=0; c--) {			//상
			dirtyRoom[clearR1][c+1] = dirtyRoom[clearR1][c];
		}
		
		//시계방향 청소기 가동
		for (int r = clearR2; r+1 <R ; r++) {	
			dirtyRoom[r][0] = dirtyRoom[r+1][0];
		}
		for (int c = 1; c < C; c++) {			
			dirtyRoom[R-1][c-1] = dirtyRoom[R-1][c];
		}
		for (int r = R-2; r >=clearR2 ; r--) {	
			dirtyRoom[r+1][C-1] = dirtyRoom[r][C-1];
		}
		for (int c = C-2; c >=0; c--) {			
			dirtyRoom[clearR2][c+1] = dirtyRoom[clearR2][c];
		}
		
		dirtyRoom[clearR1][1] = 0;
		dirtyRoom[clearR2][1] = 0;
		
		
		//다 하고나서, 룸에 복사.
		room = dirtyRoom;
		room[clearR1][0] = -1;
		room[clearR2][0] = -1;

	}

}