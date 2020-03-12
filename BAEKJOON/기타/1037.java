//백준 알고리즘 1037번 : 약수
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        for(int i = 0; i<t; i++) {
        	arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        if(t==1)
        	System.out.println(arr[0]*arr[0]);
        else
        	System.out.println(arr[0]*arr[arr.length-1]);
	}
}

