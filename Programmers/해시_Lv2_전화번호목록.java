import java.util.Arrays;

public class 해시_Lv2_전화번호목록 {

	public static void main(String[] args) {
//		String[] phone_book = {"119","97674223","1195524421"};
//		String[] phone_book = {"123","456","789"};
		String[] phone_book = {"12","123","1235","567","88"};
		System.out.println(solution(phone_book));
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i<phone_book.length;i++) {
        	for (int j = i+1; j < phone_book.length; j++) {
				if(phone_book[j].startsWith(phone_book[i])) return false;
			}
        }
        return answer;
    }
}
