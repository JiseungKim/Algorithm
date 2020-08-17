package package_3차_1급;

public class Solution03 {
	private int[][] dir = {{-1,-1},{-1,1},{1,-1},{1,1}};
	public int solution(String[] bishops) {
        // 여기에 코드를 작성해주세요.
		boolean[][] map = new boolean[8][8];
		for(int b = 0; b<bishops.length;b++) {
			int c = bishops[b].charAt(0)-'A';
			int r = bishops[b].charAt(1)-'1';
//			System.out.println(r+" "+c);
			map[r][c] = true;
			int d = 1;
			while(true) {
				int inRange = 0;
				for (int i = 0; i < 4; i++) {
					int nr = r + dir[i][0]*d;
					int nc = c + dir[i][1]*d;
//					System.out.println(nr+" "+nc);
					if(nr<8 && nr>=0 && nc<8 && nc>=0) {
						inRange++;
						map[nr][nc] = true;
					}
				}
				if(inRange==0) break;
				d++;
			}
		}
		int answer = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==false) answer++;
			}
		}
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map.length; j++) {
//				System.out.print((map[i][j]==true?1:0) + " ");
//			}
//			System.out.println();
//		}
		return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        String[] bishops1 = {new String("D5")};
        int ret1 = sol.solution(bishops1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        String[] bishops2 = {new String("D5"), new String("E8"), new String("G2")};
        int ret2 = sol.solution(bishops2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
