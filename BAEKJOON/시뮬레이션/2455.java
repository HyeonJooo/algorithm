//백준 알고리즘 2455번 : 지능형 기차
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][2];
        int sum = 0;
        int max = 0;
        
        for(int i = 0; i<4; i++) {
        	for(int j = 0; j<2; j++) {
        		arr[i][j] = sc.nextInt();
        		if(j==0) 
        			sum -= arr[i][j];
        		else 
        			sum += arr[i][j];
        		
    			if(max < sum)
    				max = sum;
        	}
        }
        System.out.println(max);
	}
}
