//백준 알고리즘 1644번 : 소수의 연속합
import java.util.*;
import java.io.*;
public class Main{
   public static void main(String args[]) throws Exception {
	   Scanner sc = new Scanner(System.in);
	   int n = sc.nextInt();
	   boolean[] arr = new boolean[n+1];
	   arr[0] = arr[1] = false;
	   for(int i = 2; i<=n; i++) {
		   arr[i] = true;
	   }
	   //에라토스테네스 체
	   for(int i = 2; i*i<=n; i++) {
		   for(int j = i*i; j<=n; j+=i) {
			   arr[j] = false;
		   }
	   }
	   
	   List<Integer> list = new ArrayList<>();
	   for(int i = 2; i<=n; i++) {
		   if(arr[i] == true)
			   list.add(i);
	   }
	   
	   int start = 0;
	   int end = 0;
	   int sum = 0;
	   int answer = 0;
	   
	   while(start <= end) {
		   if(end == list.size())
			   break;
		   else if(sum > n) {
			   start++;
			   end = start;
			   sum = 0;
		   }

		   else if(sum == n) {
			   sum = 0;
			   answer++;
			   start++;
			   end = start;
		   }
		   
		   else {
			   sum += list.get(end);
			   end++;
		   }
	   }
	   if(arr[n] == true)
		   System.out.println(answer+1);
	   else
		   System.out.println(answer);
   }
}
