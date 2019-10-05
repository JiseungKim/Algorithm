package HW0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사_김지승 {
	static StringBuilder sb = new StringBuilder();
	static String[] arr;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int result = 1;
			N = Integer.parseInt(in.readLine());
			arr = new String [N+1];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(in.readLine());
				st.nextToken();
				arr[i] = st.nextToken(); 
			}
			inorder(1);
			String str = sb.toString();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				//짝수면 숫자여야함
				if(i%2==0) {
					if(ch-'0'>=0 && ch-'0'<=9) {
						continue;
					}else {
						result = 0;
						break;
					}
				//홀수면 연산자
				}else {
					if(ch=='/'||ch=='*'||ch=='-'||ch=='+') {
						continue;
					}else {
						//연산자가 아니면,
						result = 0;
						break;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+result);
			sb.setLength(0);
		}
	}
	public static void inorder(int index) {
		if(index>N) return;
		inorder(index*2);
		sb.append(arr[index]);
		inorder(index*2+1);
	}
}
