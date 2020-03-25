//백준 알고리즘 6603번 : 로또
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
        	int k = sc.nextInt();
        	if(k==0)
        		break;
        	
        	int[] arr = new int[k];
        	for(int i =0; i<k; i++) {
        		arr[i] = sc.nextInt();
        	}
        	
        	for(int a = 0; a<k-5; a++) {
        		for(int b = a+1; b<k-4; b++) {
        			for(int c = b+1; c<k-3; c++) {
        				for(int d = c+1; d<k-2; d++) {
        					for(int e = d+1; e<k-1; e++) {
        						for(int f = e+1; f<k; f++) {
        							System.out.println(arr[a]+" "+arr[b]+" "+arr[c]+" "+arr[d]+" "+arr[e]+" "+arr[f]);
        						}
        					}
        				}
        			}
        		}
        	}
        	System.out.println("");
    	}
    }
}
