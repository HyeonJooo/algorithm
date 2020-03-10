//백준 알고리즘 10816번 : 숫자 카드2
import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	static int[] num;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        num = new int[m];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<m; i++) {
        	num[i] = Integer.parseInt(st1.nextToken());
        }
        
        Arrays.sort(arr);
        for(int i = 0 ; i<m; i++) {
        	if(upper(num[i]) == n-1 && arr[n-1] == num[i])
        		bw.write(upper(num[i]) - lower(num[i]) + 1 + " ");
        	else
        		bw.write(upper(num[i]) - lower(num[i]) +  " ");
        }
        bw.flush();
        br.close();
        bw.close();        
    }
    static int lower(int n) {
    	int mid = 0;        	
        int left = 0;
        int right = arr.length-1;
    	while(right > left) {
    		mid = (left + right) /2;	
    	
    	if(arr[mid] >= n)
    		right = mid;
    	else
    		left = mid + 1;
    	}
    	return right;
    }
    
    static int upper(int n) {
    	int mid = 0;        	
        int left = 0;
        int right = arr.length-1;
    	while(right > left) {
    		mid = (left + right) /2;	
    	
    	if(arr[mid] > n)
    		right = mid;
    	else
    		left = mid + 1;
    	}
    	return right;
    }
}
