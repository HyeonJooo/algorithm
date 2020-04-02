//백준 알고리즘 2212번 : 센서
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n; i++) {
        	arr[i] = sc.nextInt();
        }
        int[] ans = new int[n-1];
        Arrays.sort(arr);
        for(int i = 0 ; i<n-1; i++) {
        	ans[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(ans);
        int sum = 0;
        for(int i = 0 ; i<ans.length-k+1; i++) {
        	sum += ans[i];
        }
        System.out.println(sum);       
    }
}
