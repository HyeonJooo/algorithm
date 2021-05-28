import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<String> stack = new Stack<>();
        String temp = s.replaceAll("[^()\\[\\]]", "");
        if(s.length() != temp.length()) {
            System.out.println(0);
            System.exit(0);
        }
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add("(");
            }
            else if(s.charAt(i) == '[') {
                stack.add("[");
            }

            else {
                if(s.charAt(i) == ')') {
                    if(!stack.isEmpty()) {
                        if(stack.peek().equals("(")) {
                            stack.pop();
                            stack.add("2");
                        }

                        else if(stack.peek().equals("[")){
                            System.out.println(0);
                            System.exit(0);
                        }

                        else {
                            int num = 0;
                            while(true) {
                                if(stack.isEmpty())
                                    break;
                                if(stack.peek().equals("(") || stack.peek().equals("["))
                                    break;
                                num += Integer.parseInt(stack.pop());
                            }
                            if(!stack.isEmpty() && stack.peek().equals("(")) {
                                stack.pop();
                                stack.add(Integer.toString(num*2));
                            }
                            else {
                                System.out.println(0);
                                System.exit(0);
                            }
                        }
                    }
                }

                else {
                    if(!stack.isEmpty()) {
                        if(stack.peek().equals("[")) {
                            stack.pop();
                            stack.add("3");
                        }

                        else if(stack.peek().equals("(")){
                            System.out.println(0);
                            System.exit(0);
                        }

                        else {
                            int num = 0;
                            while(true) {
                                if(stack.isEmpty())
                                    break;
                                if(stack.peek().equals("(") || stack.peek().equals("["))
                                    break;
                                num += Integer.parseInt(stack.pop());
                            }
                            if(!stack.isEmpty() && stack.peek().equals("[")) {
                                stack.pop();
                                stack.add(Integer.toString(num*3));
                            }
                            else {
                                System.out.println(0);
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        if(!stack.isEmpty()) {
            if(stack.contains("(") || stack.contains("["))
                ans = 0;
            else {
                while(!stack.isEmpty()) {
                    ans += Integer.parseInt(stack.pop());
                }
            }
        }
        
        System.out.println(ans);
    }
}
