//2019 SCCC 벚꽃맞이 컨테스트
//백준 알고리즘 17127번 : 벚꽃이 정보섬에 피어난 이유
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i = 0 ; i<n; i++) {
    		arr[i] = sc.nextInt();
    	}
    	int num = n-3;
    	int sum = 1;
    	int max = 0, idx = 0;
    	
    	for(int i = 0 ; i<n-num+1; i++) {
    		sum = 1;
    		for(int j = i; j<i+num; j++) {
    			sum *= arr[j];
    		}
    		if(max < sum) {
    			max = sum;
    			idx = i;
    		}
    	}
    	
    	for(int i = 0;  i<n; i++) {
    		if(i>=idx && i<=idx+num-1)
    			continue;
    		else
    			max += arr[i];
    	}
    	System.out.println(max);
    }
}
