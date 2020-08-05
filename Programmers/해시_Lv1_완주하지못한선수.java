import java.util.Arrays;
import java.util.HashMap;

public class 해시_Lv1_완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(solution(participant, completion));
		System.out.println("답 : " + "leo");
		System.out.println();
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant2, completion2));
		System.out.println("답 : " + "vinko");
		System.out.println();
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant3, completion3));
		System.out.println("답 : " + "mislav");
		System.out.println();
	}
	
	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < participant.length; i++) {
			String key = participant[i];
			if(map.containsKey(key)) map.put(key, map.get(key)+1);
			else map.put(key, 1);
		}
		for (int i = 0; i < completion.length; i++) {
			String key = completion[i];
			map.put(key, map.get(key)-1);
		}
		String answer = "";
		for(String key : map.keySet()) {
			if(map.get(key) > 0) answer = key;
		}
        return answer;
    }
}
