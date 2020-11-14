import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int c = sc.nextInt();
    	int r = sc.nextInt();
    	int answer = sc.nextInt();
    	int[][] arr = new int[r][c];
    	
    	int i = r;
    	int j = 0;
    	int sw1 = -1;
    	int sw2 = 1;
    	int k = 1;
    	int length1 = r;
    	int length2 = c-1;
    	while(true) {
    		for(int a = length1; a>0; a--) {
    			i += sw1;
    			arr[i][j] = k;
    			if(k == answer) {
    				System.out.println((j+1) + " " + (r-i));
    				System.exit(0);
    			}
    			k++;
    		}
    		sw1 *= -1;
    		length1--;
    		
    		for(int a = 0; a<length2; a++) {
    			j += sw2;
    			arr[i][j] = k;
    			if(k == answer) {
    				System.out.println((j+1) + " " + (r-i));
    				System.exit(0);
    			}
    			k++;
    		}
    		length2--;
    		sw2 *= -1;
    		if(length1 <= 0 && length2 <= 0)
    			break;	
    	}
    	if(k < answer)
    		System.out.println(0);
    }
}
