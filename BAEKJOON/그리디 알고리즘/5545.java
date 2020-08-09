import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//토핑의 종류 수
        int a = sc.nextInt();//도우의 가격
        int b = sc.nextInt();//토핑의 가격
        int c = sc.nextInt();//도우의 열량
        int[] topping = new int[n];
        for(int i = 0 ; i<n; i++) {
        	topping[i] = sc.nextInt();//토핑의 열
        }
        Arrays.sort(topping);
    	int toppingCount = 1;
    	int sumPrice = a;
    	int answer = 0;
    	int sumCalorie = c;
        for(int i = n-1; i>=0; i--) {
        	sumPrice = a + (toppingCount*b);//피자의 가격
        	sumCalorie += topping[i];
        	answer = Math.max(answer, sumCalorie/sumPrice);
        	toppingCount++;
        }
        answer = Math.max(answer, c/a);//토핑을 선택하지 않은경우
        System.out.println(answer);
    }
}
