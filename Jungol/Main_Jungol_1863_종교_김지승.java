import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_Jungol_1863_종교_김지승 {
	private static int parents[];
	
	static int find(int a) {
		if(parents[a]<0) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void make() {
		Arrays.fill(parents, -1);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 쌍 수

		parents = new int[N+1];
		make();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int count = 0;
		//학생이 1번부터이므로 배열 인덱스1부터 탐색
		for (int i = 1; i < parents.length; i++) {
			//유니온이 끝난 후, -1이 남아있다면 루트. 루트의 수 = 종교의 수
			if(parents[i]==-1) count++;
		}
		System.out.println(count);
	}

}
