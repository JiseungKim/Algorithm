package HW0809;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.zip.InflaterInputStream;

public class Solution_D3_2805_농작물수확하기_김지승 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for (int t = 1 ; t<=test_case;t++) {
			int result;
			int size = Integer.parseInt(br.readLine());
			int[][] farm = new int[size][size];
			for (int i = 0; i < size; i++) {
				String str = br.readLine();
				for (int j = 0; j < size; j++) {
					char ch = str.charAt(j);
					int num = ch-'0';
					farm[i][j] = num;
				}
			}
			
			if(size==1) {
				result = farm[0][0];
			}else {
				int sum = 0;
				int mid = size/2;
				for (int i = 0; i <=mid; i++) {
					for (int j = mid-i; j <= mid+i; j++) {
						sum += farm[i][j];
					}
				}
				for (int i = 1; i <= mid; i++) {
					for (int j = i; j <= size-1-i; j++) {
						sum+=farm[mid+i][j];
					}
				}
				result = sum;
			}
			
			System.out.println("#"+t+" "+result);
			
		}
	}

}
