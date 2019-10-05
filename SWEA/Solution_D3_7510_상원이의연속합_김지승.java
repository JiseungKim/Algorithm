package HW0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_7510_상원이의연속합_김지승 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 1; //자기자신은 항상 포함.
			int N = Integer.parseInt(br.readLine());
			int sum;
			for (int i = 1; i <= N/2+1; i++) {
				sum = 0;
				for (int j = i; j < N; j++) {
					if(sum<N) {
						sum+=j;
					}else if(sum==N) {
						result++;
						break;
					}else break;
				}
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}

}
