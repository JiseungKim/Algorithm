package com.ssafy.step1.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr&categoryId=AWBOKg-a6l0DFAWr&categoryType=CODE
 */
public class Solution_D3_3307_최장증가부분수열_김지승 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine()); // 1<=N<=1000
			int[] numbers = new int[N];
			int[] LIS = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
				
			}
			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j <= i-1; j++) {
					if(numbers[j] < numbers[i] && 1 + LIS[j] > LIS[i]) {
						LIS[i] = LIS[j] + 1;
						if(max<LIS[i]) max = LIS[i];
					}
				}
			}
			//System.out.println(Arrays.toString(LIS));
			System.out.println("#"+tc+" "+max);
		}
	}

}
