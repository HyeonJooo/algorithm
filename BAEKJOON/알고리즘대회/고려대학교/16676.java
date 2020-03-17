//2018 고려대학교 프로그래밍 경시대회
//백준 알고리즘 16676번 : 근우의 다이어리 꾸미기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	if(n<11)
    		System.out.println(1);
    	else if(n>=11 && n<111)
    		System.out.println(2);
    	else if(n>=111 && n<1111)
    		System.out.println(3);
    	else if(n>=1111 && n<11111)
    		System.out.println(4);
    	else if(n>=11111 && n<111111)
    		System.out.println(5);
    	else if(n>=111111 && n<1111111)
    		System.out.println(6);
    	else if(n>=1111111 && n<11111111)
    		System.out.println(7);
    	else if(n>=11111111 && n<111111111)
    		System.out.println(8);
    	else
    		System.out.println(9);
    }
}
