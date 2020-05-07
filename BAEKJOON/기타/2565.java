//백준 알고리즘 2565번 : 전깃줄
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	int[][] arr = new int[n][2];
    	int[] ans = new int[n];
    	for(int i = 0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
    		arr[i][0] = Integer.parseInt(st.nextToken());
    		arr[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	 Arrays.sort(arr, new Comparator<int[]>() {

    			@Override
    			public int compare(int[] o1, int[] o2) {
    				return Integer.compare(o1[0], o2[0]);
    			} 
    	   	   });   
    	
    	int max = 0;
    	ans[0] = 1;
    	
    	for(int i = 1; i<n; i++) {
    		ans[i] = 1;
    		
    		for(int j = 0; j<i; j++) {
    			if(arr[i][1] > arr[j][1] && ans[j]+1 > ans[i])
    				ans[i] = ans[j] + 1;
    		}
    		if(max < ans[i])
        		max = ans[i];
        	
    	}
    	if(n==1)
    		System.out.println(0);
    	else
        	System.out.println(n-max);    		    	
    }
}
