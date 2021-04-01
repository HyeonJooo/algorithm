import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = "a";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 1;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i<s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty())
            answer = 1;
        else
            answer = 0;
        return answer;
    }
}
