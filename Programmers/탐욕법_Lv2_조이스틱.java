import java.util.Arrays;

public class 탐욕법_Lv2_조이스틱 {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.println(solution(people, limit));
		people = new int[] {70, 80, 50};
		System.out.println(solution(people, limit));
	}
	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
        int boat = 0;
        int left = 0, right = people.length-1;
        while(left <= right) {
        	// 두사람의 무게 합이 limit보다 작거나 같은 경우
        	if(people[left] + people[right] <= limit) left++;
        	right--;
        	boat++;
        }
        return boat;
    }
}
