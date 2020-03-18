//백준 알고리즘 1475번 : 방 번호
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	if(n == 0)
    		System.out.println(1);
    	else {
            int[] arr = new int[10];
           	while(n!=0) {
           		arr[n%10]++;
           		n /= 10;
           	}
           	
            int idx = 0, max = -1;
           	for(int i = 0 ; i<10; i++) {
           		if(max < arr[i]) {
           			max = arr[i];
            		idx = i;
            	}
           	}
           	
           	if(idx != 6 && idx !=9)
           		System.out.println(max);
           	else {
            	if((arr[6]+arr[9])%2 == 0)
               		System.out.println((arr[6]+arr[9])/2);    		
            	else
           			System.out.println((arr[6]+arr[9])/2 + 1);
        	}    		
    	}
    }
}
