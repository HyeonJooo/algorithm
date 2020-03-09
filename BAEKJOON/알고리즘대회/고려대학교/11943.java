//2016 고려대학교 프로그래밍 경시대회 2번
//백준 알고리즘 11943번 : 파일 옮기기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int c = sc.nextInt();
    	int d = sc.nextInt();
    	System.out.println(Math.min(a+d, b+c));
    }
}
