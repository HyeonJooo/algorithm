//카카오 코드 페스티벌 2018 예선
//백준 알고리즘 15954번 : 인형들
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		arr[i] = Integer.parseInt(str.nextToken());
    	}
    	
    	double m = 0;//평균
    	double variance = 0;//분산
    	double dev = 0;//표준편차
    	double min = Double.MAX_VALUE; 
    	int ktemp = k;
    	
    	for(int i = 0 ; i<n-k+1; i++) {
    		while(true) {
    			if(i+k>n)
    				break;
    			
    			for(int j = i; j<i+k; j++) {//평균구하기
        			m += arr[j];
        		}
        		m /= k;
        		
        		for(int l = i; l<i+k; l++) {//분산구하기
        			variance += Math.pow(arr[l]-m, 2);
        		}
        		variance /= k;
    			dev = Math.sqrt(variance);//표준편차구하기
    			
        		if(min > dev) {
        			min = dev;
        		}
        		m = 0;
        		variance = 0;
        		k++;
        	}
    		k = ktemp;
    	}
    	System.out.printf("%.11f\n", min);
	}
}
