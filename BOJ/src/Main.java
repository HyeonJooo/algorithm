import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
    	StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
       
        for(int i = 0; i<arr.length; i++) {
        	if(sum + 1 < arr[i])
        		break;
        	
        	sum += arr[i];
        }
        	System.out.println(sum+1);
    }
}