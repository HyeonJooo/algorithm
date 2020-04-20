//백준 알고리즘 1092번 : 배
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] arr1 = new int[n];
    	for(int i = 0 ; i<n; i++) {
    		arr1[i] = sc.nextInt();
    	}
    	int m = sc.nextInt();
    	int[] arr2 = new int[m];
    	for(int i = 0 ; i<m; i++) {
    		arr2[i] = sc.nextInt();
    	}
    	
    	Arrays.sort(arr1);
    	Arrays.sort(arr2);
		int[] arr3 = new int[n];		
    	if(arr1[arr1.length-1] < arr2[arr2.length-1]) {
    		System.out.println(-1);
    		System.exit(0);
    	}

    	else {
    		int idx = 0;
    		int cnt = 0;

    		for(int i = 0 ; i<n; i++) {
    			for(int j = idx; j<m; j++) {
    				if(j == m-1 && arr2[j] <= arr1[i]) {
    					arr3[i] = cnt+1;
    					idx = j+1;
    					break;
    				}
    				
    				else if(arr2[j] > arr1[i]) {
    					arr3[i] = cnt;
    					idx = j;
    					break;
    				}
    				else
    					cnt++;
    			}
    			cnt = 0;
    		}
    	}
    	int ans = 0;
    	while(true) {
    		boolean check = true;
    		for(int i = 0 ; i<arr3.length; i++) {
    			if(arr3[i] != 0) {
    				arr3[i]--;
    				check = false;
    			}
    			else {
    				for(int j = i-1; j>=0; j--) {
    					if(arr3[j] != 0) {
    						arr3[j]--;
    	    				check = false;
    						break;
    					}
    				}
    			}
    		}
    		if(check == true)
    			break;
    		ans++;
    	}
    	System.out.println(ans);
    }
}
