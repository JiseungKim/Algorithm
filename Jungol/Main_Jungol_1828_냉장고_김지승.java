import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Jungol_1828_냉장고_김지승 {
	public static class C implements Comparable<C>{
		int low;
		int high;
		public C(int low,int high) {
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(C o) {
			// TODO Auto-generated method stub
			return high-o.high;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		List<C> list = new ArrayList<C>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			list.add(new C(low,high));
		}
		Collections.sort(list);

		//화학물질은 한개 이상이므로 냉장고 최소 1개 필요.
		int count = 1;
		int index = 0;
		/*
		 * list중에서, 현재의 high보다 low가 큰 것 중에, high가 가장 작은 것 찾기
		 * -> 화학물질 high를 기준으로  오름차순 정렬 구현
		 */
		w:
		while(true) {
			//high가 가장 작은 화학물질받아오기
			C current = list.get(index);
			for (int j = index+1,size = list.size(); j < size; j++) {
				//현재 화학물질의 high보다 low가 크다면, 냉장고를 같이 쓸 수 없음
				if(list.get(j).low > current.high) {
					//냉장고 증가
					count++;
					//비교할 화학물질 저장
					index = j;
					//화학물질 비교 다시 시작
					continue w;
				}
			}
			//화학물질 다 봤는데 없으면 종료
			break;
		}//while
		System.out.println(count);
	}

}
