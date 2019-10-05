package HW0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen_김지승 {
	static int cols[];
	static int answer;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(in.readLine());
			cols = new int[N];
			answer = 0;
			
			dfs(0);
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

	static public void dfs(int curC) {
		if(curC==N) {
			answer++;
			return;
		}
		for (int i = 0; i < N; i++) {
			cols[curC] = i;
			if(isPossible(curC)) {
				dfs(curC+1);
			}
		}
	}//dfs
	
	static boolean isPossible(int col) {
		for (int i = 0; i < col; i++) {
			//같은 열이거나 대각선인 경우
			if(cols[i]==cols[col]
					||Math.abs(col-i)==Math.abs(cols[col]-cols[i]))
				return false;
		}
		return true;
		
	}//isPossible
}
