package com.ssafy.dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_D4_4366_정식이의은행업무_김지승 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			//배열에 거꾸로 저장.
			String n2 = in.readLine();	//2진수
			String n3 = in.readLine();	//3진수
			int l2 = n2.length();
			int l3 = n3.length();
			int[] num2 = new int[l2];
			int[] num3 = new int[l3];
			for (int i = 0; i < num2.length; i++) {
				num2[i] = n2.charAt(l2-i-1)-'0';
			}
			for (int i = 0; i < num3.length; i++) {
				num3[i] = n3.charAt(l3-i-1)-'0';
			}
			
			//2진수를 돌려보고
			long number2 = 0;
			wh:
			for (int i = 0; i < num2.length; i++) {
				if(num2[i]==0) {
					num2[i] = 1;
				}else {
					num2[i] = 0;
				}
					//System.out.println(Arrays.toString(num2));
				for (int j = 0; j < num2.length; j++) {
					number2 += num2[j]*Math.pow(2, j);
				}
				
				long number3 = 0;
				for (int k = 0; k < num3.length; k++) {
					int temp = num3[k];
					
					if(num3[k]==0) {
						num3[k]=1;
						for (int l = 0; l < num3.length; l++) {
							number3 += num3[l]*Math.pow(3, l);
						}
						
						if(number2==number3) break wh;
						number3 = 0;
						
						num3[k]=2;
						for (int l = 0; l < num3.length; l++) {
							number3 += num3[l]*Math.pow(3, l);
						}
						
						if(number2==number3) break wh;
						number3 = 0;
					}
					else if(num3[k]==1) {
						num3[k]=2;
						for (int l = 0; l < num3.length; l++) {
							number3 += num3[l]*Math.pow(3, l);
						}
						
						if(number2==number3) break wh;
						number3 = 0;
						num3[k]=0;
						for (int l = 0; l < num3.length; l++) {
							number3 += num3[l]*Math.pow(3, l);
						}
						
						if(number2==number3) break wh;
						number3 = 0;
					}
					else if(num3[k]==2) {
						num3[k]=1;
						for (int l = 0; l < num3.length; l++) {
							number3 += num3[l]*Math.pow(3, l);
						}
						
						if(number2==number3) break wh;
						number3 = 0;
						num3[k]=0;
						for (int l = 0; l < num3.length; l++) {
							number3 += num3[l]*Math.pow(3, l);
						}
						
						if(number2==number3) break wh;
						number3 = 0;
					}
					
					num3[k] = temp;
					number3 = 0;
				}
				
				
				//System.out.println(number2);
				if(num2[i]==0) {
					num2[i] = 1;
				}else {
					num2[i] = 0;
				}
			number2 = 0;
			}
			
			
			
			System.out.println("#"+tc+" "+number2);
		}
	}

}
