import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BaekJoon_17406_배열돌리기4_김지승 {
	public static class Rotation {
		int r;
		int c;
		int s;
		public Rotation(int r,int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	static int totalCount = 0;
	private static int N,M,K;
	private static Rotation[] rotation;
	private static int[] order;
	private static int[][] arr;
	private static int[][] newArr;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());	//행
		M = Integer.parseInt(st.nextToken());	//열
		K = Integer.parseInt(st.nextToken());	//회전 연산의 갯수
		arr= new int[N+1][M+1];
		newArr = new int[N+1][M+1];
		order = new int[K];
		for (int i = 0; i < K; i++) {
			order[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rotation = new Rotation[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rotation[i] = new Rotation(r, c, s);
		}
		do {
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i].clone();
			}
			for (int i = 0; i < order.length; i++) {
				rotate(rotation[order[i]]);
			}
			makeSum();
		}while(nextPermutation());
		
		System.out.println(min);
	}
	public static void rotate(Rotation rotation) {
		
		for (int k = rotation.s; k > 0; k--) {
			int size = k*2+1;
			int r = rotation.r-k;
			int c = rotation.c-k;
			int temp = newArr[r][c];	// 백업
			for (int i = 1; i < size; i++) { // 하
				newArr[r][c] = newArr[r+1][c];
				r++;
			}
			for (int i = 1; i < size; i++) { // 우
				newArr[r][c] = newArr[r][c+1]; 
				c++;
			}
			for (int i = 1; i < size; i++) { // 상
				newArr[r][c] = newArr[r-1][c]; 
				r--;
			}
			for (int i = 1; i < size; i++) { // 좌
				newArr[r][c] = newArr[r][c-1]; 
				c--;
			}
			newArr[r][c+1] = temp; // 백업했던 것 넣기
		}
		//사이클
	}
	public static boolean nextPermutation() {
		int i = K-1;
		
		while(i>0 && order[i-1]>=order[i]) --i;
		if(i==0) return false;
		
		int j = K-1;
		while(order[i-1]>=order[j]) --j;
		swap(i-1,j);
		
		j = K-1;
		while(i<j) swap(i++,j--);
		return true;
	}
	public static void swap(int i,int j) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}
	public static void makeSum() {
		for (int r = 1; r <= N; r++) {
			int rowSum = 0;
			for (int c = 1; c <= M; c++) {
				rowSum += newArr[r][c];
			}
			if(min>rowSum) min = rowSum;
		}
	}
}