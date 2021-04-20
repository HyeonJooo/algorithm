import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = "[(])";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        String word = "";
        String[] st = s.split("");
        for(int i = 0 ; i<s.length(); i++) {
            for(int j = i; j<s.length(); j++) {
                word += st[j];
            }
            for(int j = 0; j<i; j++) {
                word += st[j];
            }
            boolean check = isCorrect(word);
            if(check)
                answer++;
            word = "";
        }
        return answer;
    }

    public static boolean isCorrect(String s) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        Stack<String> stack3 = new Stack<>();
        Stack<String> topStack = new Stack<>();
        String[] temp = s.split("");
        String top = "";
        for(int i = 0 ; i<s.length(); i++) {
            if(temp[i].equals("[")) {
                stack1.push(temp[i]);
                topStack.push(temp[i]);
                top = temp[i];
            }

            else if(temp[i].equals("]")) {
                if(!top.equals("["))
                    return false;
                if(!stack1.isEmpty()) {
                    stack1.pop();
                    topStack.pop();
                    if(!topStack.isEmpty())
                        top = topStack.peek();
                    else
                        top = "";
                }

                else
                    return false;
            }

            if(temp[i].equals("{")) {
                stack2.push(temp[i]);
                topStack.push(temp[i]);
                top = temp[i];
            }

            else if(temp[i].equals("}")) {
                if(!top.equals("{"))
                    return false;
                if(!stack2.isEmpty()) {
                    stack2.pop();
                    topStack.pop();
                    if(!topStack.isEmpty())
                        top = topStack.peek();
                    else
                        top = "";
                }
                else
                    return false;
            }

            if(temp[i].equals("(")) {
                stack3.push(temp[i]);
                topStack.push(temp[i]);
                top = temp[i];
            }

            else if(temp[i].equals(")")) {
                if(!top.equals("("))
                    return false;
                if(!stack3.isEmpty()) {
                    stack3.pop();
                    topStack.pop();
                    if(!topStack.isEmpty())
                        top = topStack.peek();
                    else
                        top = "";
                }
                else
                    return false;
            }
        }
        if(stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty())
            return true;
        return false;
    }
}
