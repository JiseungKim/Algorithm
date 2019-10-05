import java.util.Scanner;

public class Main_B6987_월드컵_김지승 {
	//팀 붙게되는 경우의 수
	/*
	 * A vs B C D E F
	 * B vs C D E F
	 * C vs D E F
	 * D vs E F
	 * E vs F
	 * 각 숫자는 팀의 index
	 */
	static int[] team1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] team2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	//TC저장
	private static int[][][] arr;
	//값 계산할 결과
	private static int[][] res;		//결과 중간 저장
	private static int[] answer;	//TC에 대한 결과
	//
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[4][6][3];
		res = new int[6][3];
		answer = new int[4];
		for (int g = 0; g < 4; g++) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					arr[g][i][j] = sc.nextInt();
				}
			}
		}
//		long start = System.currentTimeMillis();
		game(0);
//		long end = System.currentTimeMillis();
//		System.out.println("실행시간 : "+(end-start)+"ms");
		//답 출력
		for (int i = 0; i < 4; i++) {
			System.out.print(answer[i]+" ");
		}
	}

	private static void game(int round) {
		if(round == 15) {
			//맞는지 검사.
			an:
			for (int a = 0; a < 4; a++) {
				if (answer[a]==1) continue; // 이미 답인 경우는 볼 필요 없음
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						//하나라도 다르면 다음 answer 비교
						if(arr[a][i][j]!=res[i][j]) continue an;
					}
				}
				//for문 다 돌음 -> 답과 일치
				answer[a] = 1;
			}
			return;
		}
		
		int t1 = team1[round];
		int t2 = team2[round];
		
		/*
			한 라운드의 경우의 수 : 3개
			Team1 승리		Team2 패배
			Team1 비김		Team2 비김
			Team1 패배		Team2 승리
		*/
		//팀1 이김, 팀2 짐
		res[t1][0]++;
		res[t2][2]++;
		game(round+1);
		res[t1][0]--;
		res[t2][2]--;
		
		//비김
		res[t1][1]++;
		res[t2][1]++;
		game(round+1);
		res[t1][1]--;
		res[t2][1]--;
		
		//팀1 짐, 팀2 이김
		res[t1][2]++;
		res[t2][0]++;
		game(round+1);
		res[t1][2]--;
		res[t2][0]--;
	}
}
