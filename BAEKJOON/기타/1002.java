//백준 알고리즘 1002번 : 터렛
import java.util.*;
import java.io.*;
public class Main{
   public static void main(String args[]){
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int x1=0,y1=0,r1=0,x2=0,y2=0,r2=0;
       double d=0;
	   for(int i = 0; i<t; i++) {
		   x1 = sc.nextInt();
		   y1 = sc.nextInt();
		   r1 = sc.nextInt();
		   x2 = sc.nextInt();
		   y2 = sc.nextInt();
		   r2 = sc.nextInt();
		   d = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		   
		   if(d == (r1+r2)) {
			   System.out.println(1);
		   }
		   
		   else if(d > (r1+r2)) {
			   System.out.println(0);
		   }
		   else if (d == 0)
			   if(r1==r2)
				   System.out.println(-1);
			   else
				   System.out.println(0);
		   
		   else {
			   if(Math.abs(r1-r2)<d)
				   System.out.println(2);
			   
			   else if(Math.abs(r1-r2) == d)
				   System.out.println(1);
			   
			   else if(Math.abs(r1-r2)>d)
				   System.out.println(0);
			   
			   else
				   System.out.println(-1);
		   }
	   }
   }
}
