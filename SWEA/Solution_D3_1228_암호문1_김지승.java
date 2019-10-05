package HW0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1_김지승 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			//원본 암호문의 길이
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			LinkedList<String> list = new LinkedList<String>();
			//원본 암호문 연결리스트에 삽입
			for (int i = 0; i < len; i++) {
				list.add(st.nextToken());
			}
			
			//명령어 갯수
			int cmd_count = Integer.parseInt(br.readLine());
			str = br.readLine();
			
			StringTokenizer cmds = new StringTokenizer(str);
			for (int i = 0; i < cmd_count; i++) {
				//I 삭제
				cmds.nextToken();
				//삽입할 위치
				int location = Integer.parseInt(cmds.nextToken()); // 삽입할 위치
				int count = Integer.parseInt(cmds.nextToken()); //삽입할 갯수
				for (int j = 0; j < count; j++) {
					String cmd = cmds.nextToken();
					list.add(location,cmd);
					//삽입해야 하는 위치 +1
					location++;
				}
			}
			StringBuilder sb = new StringBuilder();
			String[] ps_10 = new String[10];
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)+" ");
			}
			System.out.println("#"+test_case+" "+sb);
		}
	}

}
