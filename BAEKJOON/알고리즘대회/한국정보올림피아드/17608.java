//KOI 2019 1차대회 초등부
//백준 알고리즘 17608번 : 막대기
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
        	
        int count = 1;
        int max = arr[arr.length-1];
        
        for(int i = arr.length-1; i>=0; i--) {
        	if(arr[i] > max) {
        		max = arr[i];
        		count++;
        	}
        }
        System.out.println(count);
    }
}
