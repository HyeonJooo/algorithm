import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int[] arr = new int[5];
    	for(int i = 0 ; i<5; i++) {
    		arr[i] = sc.nextInt();
    	}
    	while(true) {
    		int check = 0;    	
        	for(int i = 0; i<4; i++) {
        		if(arr[i] > arr[i+1]) {
        			check = 1;
        			int tmp = arr[i];
        			arr[i] = arr[i+1];
        			arr[i+1] = tmp;
        			for(int k : arr) {
        				System.out.print(k + " ");
        			}System.out.println("");
        		}
        	}
        	if(check == 0)
        		break;
    	}
    }
}
