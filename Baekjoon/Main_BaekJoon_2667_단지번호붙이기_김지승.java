import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main_BaekJoon_2667_단지번호붙이기_김지승 {
	static int N;
	static int[][] map;
	static int count; //단지 수
	static List<Integer> list = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		// 배열에 넣기
		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c]==1) {
					dfs(r,c);			
					list.add(count);
					count = 0;
				}//end if
			}
		}//end for
		
		// 1 : 집이 있는 곳
		// 0 : 집이 없는 곳
		int[] danji = new int[list.size()];
		for (int i = 0; i < danji.length; i++) {
			danji[i] = list.get(i);
		}
		Arrays.sort(danji);
		System.out.println(list.size());
		for (int i : danji) {
			System.out.println(i+" ");
		}
		// 단지내 집의 수를 오름차순으로 정렬
	}
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean[][] visited;
	public static void dfs(int curRow, int curCol) {
		map[curRow][curCol] = 2;
		count++;
		for (int i = 0; i < 4; i++) {
			int newRow = curRow + dir[i][0];
			int newCol = curCol + dir[i][1];
			if(checkBound(newRow,newCol)			// 경계 안에 있고,
					&& map[newRow][newCol]==1) {	// 방문한 적 없다면
				dfs(newRow,newCol);			
			}
				
		}//방향검사 for
	}
	public static boolean checkBound(int r,int c) {
		if(r<N && r>=0 && c<N && c>=0) return true;
		return false;
	}

}
