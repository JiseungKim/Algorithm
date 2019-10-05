package HW0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7732_시간개념_김지승 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String now = br.readLine();
			StringTokenizer times = new StringTokenizer(now, ":");
			int now_hour = Integer.parseInt(times.nextToken());
			int now_minute = Integer.parseInt(times.nextToken());
			int now_second = Integer.parseInt(times.nextToken());

			String target = br.readLine();
			times = new StringTokenizer(target, ":");
			int target_hour = Integer.parseInt(times.nextToken());
			int target_minute = Integer.parseInt(times.nextToken());
			int target_second = Integer.parseInt(times.nextToken());
			
			
			int sub_hour = target_hour-now_hour;
			if(sub_hour<0)sub_hour+=24;
			int sub_minute = target_minute-now_minute;
			if(sub_minute<0) {
				sub_hour -=1 ;
				if(sub_hour<0) sub_hour+= 24;
				sub_minute += 60;
			}
			int sub_second = target_second-now_second;
			if(sub_second<0) {
				sub_minute -= 1;
				sub_second += 60;
			}
			
			StringBuilder result = new StringBuilder();
			String str_hour,str_minute,str_second;
			if(sub_hour<10) {
				str_hour = "0"+sub_hour;
			}else {
				str_hour = sub_hour+"";
			}
			if(sub_minute<10) {
				str_minute = "0"+sub_minute;
			}else {
				str_minute = sub_minute+"";
			}
			if(sub_second<10) {
				str_second = "0"+sub_second;
			}else {
				str_second = sub_second+"";
			}
			result.append(str_hour);
			result.append(":");
			result.append(str_minute);
			result.append(":");
			result.append(str_second);
			System.out.println("#"+test_case+" "+result);
		}
	}

}
