//백준 알고리즘 10773 : 제로

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int k = sc.nextInt();
        int sum = 0;
        
        for(int i = 0 ; i<k; i++) {
        	int num = sc.nextInt();
        	if(num != 0)
        		stack.push(num);
        	else
        		stack.pop();
        }
        while(!stack.isEmpty())
        	sum += stack.pop();
        
        System.out.println(sum);
    }
}
