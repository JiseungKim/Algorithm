package HW0801;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Baekjoon_2493_탑_김지승 {
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      
      int[] top = new int[N];
      int[] res = new int[N];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for (int i=0; i < N; i++) {
         top[i] = Integer.parseInt(st.nextToken());
         for(int j=i-1; j>=0; j--) {
            if(top[i] <= top[j]) {
               res[i] = j+1;
               break;
            }
         }
      }
      for(int i=0; i< res.length; i++)
         System.out.print(res[i] + " ");
      
   }   
}