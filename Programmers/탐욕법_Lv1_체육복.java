import java.util.Arrays;

public class 탐욕법_Lv1_체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {3};
		int[] reserve = {1};
		System.out.println(solution(n,lost,reserve));
	}
	public static int solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);
		// 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
		// 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,
		// 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
		int[] student = new int[n+1];
		Arrays.fill(student, 1);
		for (int i = 0; i < lost.length; i++) {
			student[lost[i]] = 0;
		}
		for (int i = 0; i < reserve.length; i++) {
			student[reserve[i]]++;
		}
		
		for (int i = 1; i < student.length; i++) {
			if(student[i] == 0) {
				if(student[i-1] > 1) { // 앞번호친구가 여벌이 있다면
					student[i-1]--;
					student[i]++;
				}else if(i+1<=n && student[i+1] > 1) {
					student[i+1]--;
					student[i]++;
				}
			}
		}
		
        int answer = 0;
        // System.out.println(Arrays.toString(student));
        for (int i = 1; i < student.length; i++) {
			if(student[i] > 0) answer++;
		}
        return answer;
    }
}
