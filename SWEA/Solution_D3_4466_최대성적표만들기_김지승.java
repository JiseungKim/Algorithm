package HW0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_4466_최대성적표만들기_김지승 {
	static int max;
	static List<Integer> scores;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
//			int[] score = new int[N];
			scores = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				scores.add(Integer.parseInt(st.nextToken()));
			}
			int sum = 0;
			for (int k = 0; k < K; k++) {
				int index = findMaxIndex(scores);
				sum += max;
				max = 0;
				scores.remove(index);
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
	public static int findMaxIndex(List<Integer> list) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)>=max) {
				max = list.get(i);
				index = i;
			}
		}
		return index;
	}
}
