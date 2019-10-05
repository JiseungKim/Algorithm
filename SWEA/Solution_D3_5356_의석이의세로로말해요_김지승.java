package HW0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_5356_의석이의세로로말해요_김지승 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <=  T; test_case++) {
			StringBuffer sb = new StringBuffer();
			char[][] chars = new char[5][15];
			for (int i = 0; i < 5 ; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					char sub = str.charAt(j);
					if(check(sub)) {
						chars[i][j] = sub;
					}else {
						break;
					}
				}
			}
			
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					char cha = chars[i][j];
					if(check(cha)) {
						sb.append(chars[i][j]);
					}
				}
			}
			System.out.println("#"+test_case+" "+sb);
		}
	}
	//유효한 문자인지 체크하는 메서드
	public static boolean check(char ch) {
		if((ch>='A'+0 && ch<='Z'+0) || (ch>='a'+0 && ch<= 'z'+0) || (ch>='0'+0 && ch<= '9'+0)) {
			return true;
		}else return false;
	}

}
