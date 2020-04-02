//백준 알고리즘 1758번 : 알바생 강호
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n; i++) {
        	arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long sum = 0;
        int order = 0;
        for(int i = n-1; i>=0; i--) {
        	if(arr[i] - order <=0)
        		break;
        	sum += arr[i] - order;
        	order++;
        }
        System.out.println(sum);       
    }
}
