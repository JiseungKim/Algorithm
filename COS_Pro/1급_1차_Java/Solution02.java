package package_1차_1급;

import java.util.Arrays;

public class Solution02 {
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public int solution(int n) {
		int[][] arr = new int[n][n];
		int num = 1;
		int r = 0;
		int c = 0;
		int d = 0;
		while(num <= n*n) {
			arr[r][c] = num;
			
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if(nr<0 || nr>=n || nc<0 || nc>=n
					|| arr[nr][nc]!=0) {
				// 방향 전환
				d = (d+1)%4;
				nr = r + dir[d][0];
				nc = c + dir[d][1];
			}
			r = nr;
			c = nc;
			num++;
		}
        int answer = 0;
        for (int i = 0; i < n; i++) {
        	answer += arr[i][i];
        }
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution02 sol = new Solution02();
        int n1 = 3;
        int ret1 = sol.solution(n1);

        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");
        
        int n2 = 2;
        int ret2 = sol.solution(n2);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}
