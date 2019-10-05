package HW0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_4789_성공적인공연기획_김지승 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			//고용할 사람
			int goyong = 0;
			//박수 치고있는 사람 수.
			int current = str.charAt(0)-'0';
			for (int i = 1; i < str.length(); i++) {
//				n번째 사람은, 0명일때 박수치고 있는 사람이 n명이어야 박수침.
				int new_persons = str.charAt(i)-'0';
//				현재 박수칠사람을 더해줄 사람이 없으므로 continue
				if(new_persons==0) continue;
//				만약 현재 박수치는 사람이 i명보다 적으면, 고용
				if(current<=i) {
					//부족한 사람 수
					int boojok = i - current;
					goyong += boojok;
					current += boojok;
				}
				current += new_persons;
			}
			System.out.println("#"+test_case+" "+goyong);
		}
	}

}
