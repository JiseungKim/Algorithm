import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Jungol_1037_오류고정 {
	static int N; 
	static int array[][];
	static int saveR;
	static int saveC;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		array = new int[N+1][N+1];
		for (int r = 1; r < N+1; r++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int c = 1; c < N+1; c++) {
				array[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(isParity()) {
			System.out.println("OK");
		}else {
			array[saveR][saveC] = array[saveR][saveC]==1?0:1;
			int ansR = saveR;
			int ansC = saveC;
			if(isParity()) {
				System.out.println("Change bit ("+ansR+","+ansC+")");
			}else System.out.println("Corrupt");
		}
		
	}

	private static boolean isParity() {
		boolean parity = true;
		int countC = 0, countR = 0;
		saveR = saveC = 0;
		
		for (int r = 1; r < N+1; r++) {
			countC = 0;
			for (int c = 1; c < N+1; c++) {
				if(array[r][c]==1) countC++;
			}
			if(countC%2!=0) {
				saveR = r;
				parity = false;
				break;
			}
		}
		for (int c = 1; c < N+1; c++) {
			countR = 0;
			for (int r = 1; r < N+1; r++) {
				if(array[r][c]==1) countR++;
			}
			if(countR%2!=0) {
				saveC = c;
				parity = false;
				break;
			}
		}
		return parity;
	}
}