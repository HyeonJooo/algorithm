//백준 알고리즘 10798번 : 세로읽기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       String[][] arr = new String[5][15];
       for(int i = 0; i<5; i++) {
    	   String s = sc.next();
    	   while(s.length()!=15) {
    		   s += "#";
    	   }
    	   arr[i] = s.split("");
       }
       
       for(int i = 0 ;i<15; i++) {
    	   for(int j = 0 ; j<5; j++) {	
    		   if(!arr[j][i].equals("#"))
    			   System.out.print(arr[j][i]);
    	   }
       }
    }
}
