import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기_김지승 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 1;
			int N = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			Stack<Character> chars = new Stack<>();
			//계산하기 쉽도록 배열에 넣음.
			char[] char_array = {'(',')','[',']','{','}','<','>'};
			check :
			for (int i = 0,size=str.length(); i < size; i++) {
				//cha를 받아옴. (이거나 [이거나 {이거나 <이면, 스택에 넣음.
				char cha = str.charAt(i);
				char get; //pop한 문자
				char get_char_array = 0;
				switch(cha) {
				case '(' :
				case '[' :
				case '{' :
				case '<' :
					chars.push(cha);
					break;
				case ')' : 
				case ']' : 
				case '}' : 
				case '>' : 
					//닫는괄호인데 스택이 비어있다면
					if(chars.isEmpty()) {
						break check;
					}
					//pair검사
					for (int j = 0,size2=char_array.length; j < size2; j++) {
						if(char_array[j]==cha) { //방금 읽은 것이 위에애들이라면,
							//짝이 맞는 친구들 : 바로앞의것 ( [ { <!으로 받아옴
							get_char_array = char_array[j-1]; 
							break;
						}
					}
					//스택에서 꺼낸 것이 앞에서 매칭해준 ( [ { <와 같다면, 다음것을 스택에 넣기위해 break
					if(chars.pop().equals(get_char_array)) { 
						break; //switch break
					}else { //다르다면, 뒤에것을 검사해볼 필요 없이 테스트 종료.
						answer = 0;
						break check;
					}
				}
				//모든것이 다 검사되어 스택이 비었다면, 유효함
				if(chars.isEmpty()==true) { 
					answer = 1;
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

}
