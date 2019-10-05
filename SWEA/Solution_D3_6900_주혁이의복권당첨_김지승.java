package HW0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_D3_6900_주혁이의복권당첨_김지승 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <=  T; test_case++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int lucky_number = Integer.parseInt(st.nextToken());
			int joohyuk_number = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> lucky_numbers = new HashMap<>();
			for (int i = 0; i < lucky_number; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				String key = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				lucky_numbers.put(key, value);
			}
			int sum = 0;
			for (int i = 0; i < joohyuk_number; i++) {
				boolean dangchum = false;
				str = br.readLine();
				Set<String> keys = lucky_numbers.keySet();
				for (String string : keys) {
					//주혁이가 갖고있는걸 하나하나 key에 비교
					for (int j = 0; j < 8; j++) {
						//별이거나, 같다면.
						if(string.charAt(j)=='*'
								||str.charAt(j)==string.charAt(j)){
							dangchum = true;
						}else {
							dangchum = false;
							break;
						}
					}
					//당첨됐으면, key비교 그만두고 해시맵에서 해당 금액 찾음.
					if(dangchum) {
						sum += lucky_numbers.get(string);
						break;
					}
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}

}
