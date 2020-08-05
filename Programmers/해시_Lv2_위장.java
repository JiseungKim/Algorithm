import java.util.Arrays;
import java.util.HashMap;

public class 해시_Lv2_위장 {

	public static void main(String[] args) {
		String[][] clothes = {
				{"yellow_hat","headgear"},
				{"blue_sunglasses","eyewear"},
				{"green_turban","headgear"}};
		System.out.println(solution(clothes));
	}
	public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
		}
        
        int answer = 1;
        for(int num : map.values()) answer*=(num+1); // 가짓수+1(안입는 경우)
        
        return answer-1; // 아무것도 안입는 경우 -1
    }
}
