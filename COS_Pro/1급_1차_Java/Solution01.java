package package_1차_1급;

public class Solution01 {
	static class Solution {
		// 제공한 정답
	    public long solution(long num) {
	        num++;
	        long digit = 1;
	        while (num / digit % 10 == 0) {
	            num += digit;
	            digit *= 10;
	        }
	        return num;
	    }
	}
	public long solution(long num) {
        // Write code here.
		num++;
		String numStr = num+"";
		char[] numArr = numStr.toCharArray();
		
		for (int i = 0; i < numArr.length; i++) {
			if(numArr[i]=='0') numArr[i] = '1';
		}
		
        long answer = Long.parseLong(String.valueOf(numArr));
        
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        long num = 9949999;
        num = 352535235;
        long ret = sol.solution(num);
        Solution sol2 = new Solution();
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
        System.out.println("답:"+sol2.solution(num));
    }
}
