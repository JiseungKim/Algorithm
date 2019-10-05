import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_김지승 {
	static char[] numbers;
	static int size;	//numbers 갯수
	static int exchange;	//교환 횟수
	static int max;
	static int[] maxPriceByCount;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String before = st.nextToken();
			exchange = Integer.parseInt(st.nextToken());
			size = before.length();
			numbers = new char[size];
			maxPriceByCount = new int[11];
			for (int i = 0; i < size; i++) {
				numbers[i] = before.charAt(i);
			}
			max = price();
			exchange(0);
			System.out.println("#"+test_case+" "+max);
		}
	}
	private static void swap(int i, int j) {
		char temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	private static void exchange(int count) {
		int money = price();
		//교환해야하는만큼 교환하게되면
		if(count == exchange) {
			//최댓값 비교하여 저장
			if(money>max) max = money;
			return;
		}
		if(maxPriceByCount[count] > money) return;
		else maxPriceByCount[count] = money;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				swap(i,j);
				exchange(count+1);
				swap(i,j);
			}
		}
	}
	private static int price() {
		int size = numbers.length-1;
		int price = 0;
		for (int i = size; i >= 0; i--) {
			price += Math.pow(10, i) * (numbers[size-i]-'0');
		}
		return price;
	}
}
