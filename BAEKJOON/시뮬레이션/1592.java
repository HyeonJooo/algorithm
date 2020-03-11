//백준 알고리즘 1592번 : 영식이와 친구들
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n+1];
        arr[1] = 1;
        int next = 1;
        int cnt = 0;
        
        while(true) {
        	if(arr[next]%2 == 1) { //현재 공을 받은 횟수가 홀수번이면
        		next += l; //시계방향으로 L번째한테
        		if(next >n)
        			next = next % n;
        	}
        	else {
        		next -= l; //짝수번이면 반시계방향으로 L번째한테
        		if(next<1) {
        			next = next + n;
        		}
        	}
        	arr[next]++; //받은 사람의 카운트 1증가
        	cnt++;
        	if(arr[next] == m)
        		break;
        }
        System.out.println(cnt);
    }
}
