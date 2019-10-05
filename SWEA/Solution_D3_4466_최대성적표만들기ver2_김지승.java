package HW0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_D3_4466_최대성적표만들기ver2_김지승 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score);
			int sum = 0;
			int k = score.length-1;
			while(k>=score.length-K) {
				sum+= score[k];
				k--;
			}
//			
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
