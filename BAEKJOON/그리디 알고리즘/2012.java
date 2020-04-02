//백준 알고리즘 2012번 : 등수 매기기
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
        int order = 1;
        for(int i = 0; i<n; i++) {
        	sum += Math.abs(arr[i] - order);
        	order++;
        }
        System.out.println(sum);
    }
}
