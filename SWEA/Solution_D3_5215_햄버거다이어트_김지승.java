import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트_김지승 {
	public static class Ingredient{
		int score;
		int calory;
		public Ingredient(int score, int calory) {
			super();
			this.score = score;
			this.calory = calory;
		}
		
	}
	static boolean[] checked; 
	static int N; //점수
	static int L; //제한 칼로리
	static Ingredient[] ingredients;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			maxScore = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			//점수.
			N = Integer.parseInt(st.nextToken());
			ingredients = new Ingredient[N];
			checked = new boolean[N];
			//칼로리.
			L = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int sc = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				ingredients[i] = new Ingredient(sc,cal);
			}
//			for (Ingredient ingredient : ingredients) {
//				System.out.println(ingredient.score + " " + ingredient.calory);
//			}
			make(0,0);
			System.out.println("#"+test_case+" "+maxScore);
		}
	}
	static int maxScore;
	private static void make(int index,int calories) {
		if(calories>L) return;
		if(index==N) {
			int scores = 0;
			for (int i = 0; i < N; i++) {
				if(checked[i]==true) scores += ingredients[i].score;
			}
			if(maxScore<scores) maxScore = scores;
			return;
		}
		//선택
		checked[index] = true;
		make(index+1,calories+ingredients[index].calory);
		//안선택
		checked[index] = false;
		make(index+1,calories);
	}

}
