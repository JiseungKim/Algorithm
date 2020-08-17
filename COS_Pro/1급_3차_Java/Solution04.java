package package_3차_1급;
import java.util.*;

public class Solution04 {
	public int solution(String s1, String s2) {
        // 여기에 코드를 작성해주세요.
		int max = 0;
		for (int i = 0; i < s1.length(); i++) {
			int count = 0;
			for (int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					count++;
				}else {
					max = Math.max(count, max);
					break;
				}
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			int count = 0;
			for (int j = 0; j < s1.length(); j++) {
				if(s1.charAt(j)==s2.charAt(i)) {
					count++;
				}else {
					max = Math.max(count, max);
					break;
				}
			}
		}
		System.out.println(max);
        int answer = s1.length()+s2.length()-max;
        return answer;
    }
    
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution04 sol = new Solution04();
        String s1 = new String("ababc");
        String s2 = new String("abcdab");
        int ret = sol.solution(s1, s2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
