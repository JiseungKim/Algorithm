import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_J2543_타일채우기_김지승 {
	private static int N;
	private static int[][] map;
	private static int R;
	private static int C;
	private static ArrayList<int[]> list;
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[N][N];
		list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			//타일 안채워진것 : -1
			Arrays.fill(map[i], -1);
		}
		map[R][C] = 0;
		list.add(new int[] {R,C});
		//입력 end
		
		part(0,0,N);
	
		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static int d = -1;
	private static void part(int sr, int sc, int size) {
		//가독성을 위함
		int top		= sr + size/2-1;
		int bot		= sr + size/2;
		int left	= sc + size/2-1;
		int right	= sc + size/2;
		
		//탐색 효율적으로 하기위해 정렬 : 행기준 오름차순, 열기준 오름차순
		Collections.sort(list,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0]) return Integer.compare(o1[0], o2[0]);
				else return Integer.compare(o1[1], o2[1]);
			}
		});
		
		//채워진 타일 리스트 중, 현재 탐색 범위에 있는것을 찾기 위함
		for(int i = 0;i < list.size();i++) {
			//현재 탐색범위에 있는 타일이 있다면
			if(list.get(i)[0]>=sr&& list.get(i)[0]<sr+size
					&& list.get(i)[1]>=sc && list.get(i)[1]<sc+size) {
				int r = list.get(i)[0];
				int c = list.get(i)[1];
				list.remove(i);
				/*
				 * 분할
				 * 1  2
				 * 3  4
				 */
				if		(r< bot	&&c< right)	d = 1; 
				else if	(r< bot	&&c>=right)	d = 2; 
				else if	(r>=bot	&&c< right)	d = 3; 
				else if	(r>=bot	&&c>=right)	d = 4;
				
				// 반대편이 비어있는지 검사
				boolean empty = true;
				if(d!=1 && map[top][ left]>=0) empty = false;
				if(d!=2 && map[top][right]>=0) empty = false;
				if(d!=3 && map[bot][ left]>=0) empty = false;
				if(d!=4 && map[bot][right]>=0) empty = false;
				
				//비어있다면 채움
				if(empty) {
					if(d!=1) {
						map[top][left] = d;
						list.add(new int[] {top,left});
					} else list.add(new int[] {r,c});
					if(d!=2) {
						map[top][right] = d;
						list.add(new int[] {top,right});
					} else list.add(new int[] {r,c});
					if(d!=3) {
						map[bot][left] = d;
						list.add(new int[] {bot,left});
					} else list.add(new int[] {r,c});
					if(d!=4) {
						map[bot][right] = d;
						list.add(new int[] {bot,right});
					} else list.add(new int[] {r,c});
				}
				
				if(size>2) {
					part(sr,		sc,			size/2);// 1
					part(sr,		sc+size/2,	size/2);// 2
					part(sr+size/2,	sc,			size/2);// 3
					part(sr+size/2,	sc+size/2,	size/2);// 4
				}
			}else if(list.get(i)[0]>sr+size) { //범위 벗어나면 탐색 종료
				break;
			}
		}
		
	}

}
