import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_J2247_도서관_김지승 {
	static class Student implements Comparable<Student>{
		int start;
		int end;
		public Student(int start,int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Student o) {
			if(start==o.start) return end-o.end; 
			else return start - o.start;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		Student[] S = new Student[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			S[i] = new Student(s,e);
		}
		Arrays.sort(S);
		
		int stayMAX = 0;
		int emptyMAX = 0;
		
		int start = S[0].start;
		int end = S[0].end;
		
		for (int i = 1; i < S.length; i++) {
			if(S[i].start <= end) { //도서관이 안빔
				end = Math.max(end, S[i].end);
				if(i==N-1) stayMAX = Math.max(stayMAX, end-start);
			}else { //도서관이 빔
				stayMAX = Math.max(stayMAX, end-start);
				start = S[i].start;
				emptyMAX = Math.max(emptyMAX, start-end);
				end = S[i].end;
			}
		}
		
		System.out.println(stayMAX+" "+emptyMAX);
	}

}
