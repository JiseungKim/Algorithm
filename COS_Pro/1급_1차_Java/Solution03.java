package package_1차_1급;

public class Solution03 {
	private static int[][] dir = {
				{-2,-1},{-2, 1},
			{-1,-2},		{-1, 2},
			{ 1,-2},		{ 1, 2},
				{ 2,-1},{ 2, 1}
	};
	public int solution(String pos) {
        // Write code here.
		int r = pos.charAt(0)-'A';
		int c = pos.charAt(1)-'1';
//		System.out.println(r+" "+c);
		
		int answer = 0;
		for (int i = 0; i < dir.length; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>=0 && nr<8 && nc>=0 && nc<8) answer++;
		}
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        String pos = "A7";
        int ret = sol.solution(pos);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
