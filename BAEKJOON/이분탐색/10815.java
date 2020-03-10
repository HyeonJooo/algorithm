//백준 알고리즘 10815번 : 숫자 카드
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i <n; i++) {
        	arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] num = new int[m];
        for(int i = 0 ; i<m; i++) {
        	num[i] = sc.nextInt();
        }
        Arrays.sort(arr);       
        
        for(int i = 0 ; i<m; i++) {
        	int tmp = Arrays.binarySearch(arr, num[i]);
        	if(tmp<0)
        		System.out.print(0 + " ");
        	else
        		System.out.print(1 + " ");
        }     
    }
}
