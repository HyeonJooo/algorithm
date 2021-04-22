import java.util.*;
import java.io.*;

public class Main{
    public static int[] parent;
    public static boolean[] visit;
    public static String[] type;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            parent = new int[10000];
            visit = new boolean[10000];
            type = new String[10000];

            System.out.println(bfs(a,b));
        }
    }

    public static String bfs(int a, int b) {
        String answer = "";
        visit[a] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while(!queue.isEmpty()) {
            int num = queue.poll();
            int d = insD(num);
            if(!visit[d]) {
                visit[d] = true;
                parent[d] = num;
                type[d] = "D";
                queue.add(d);
            }
            if(d == b)
                break;

            int s = insS(num);
            if(!visit[s]) {
                visit[s] = true;
                parent[s] = num;
                type[s] = "S";
                queue.add(s);
            }
            if(s == b)
                break;

            int l = insL(num);
            if(!visit[l]) {
                visit[l] = true;
                parent[l] = num;
                type[l] = "L";
                queue.add(l);
            }
            if(l == b)
                break;

            int r = insR(num);
            if(!visit[r]) {
                visit[r] = true;
                parent[r] = num;
                type[r] = "R";
                queue.add(r);
            }
            if(r == b)
                break;
        }

        int ins = b;
        Stack<String> stack = new Stack<>();
        while(true) {
            if(ins == a)
                break;
            stack.push(type[ins]);
            ins = parent[ins];
        }
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }

    public static int insD(int num) {
        int n = (num * 2) % 10000;
        return n;
    }

    public static int insS(int num) {
        if(num == 0)
            return 9999;
        int n = num-1;
        return n;
    }

    public static int insL(int num) {
        String s = Integer.toString(num);
        String zero = "";
        if(s.length() != 4) {
            for(int i = 0 ; i<4-s.length(); i++)
                zero += "0";
        }
        zero += s;
        s = zero;
        String temp = "";
        for(int i = 1; i<s.length(); i++) {
            temp += s.toCharArray()[i];
        }
        temp += s.toCharArray()[0];
        int n = Integer.parseInt(temp);
        return n;
    }

    public static int insR(int num) {
        String s = Integer.toString(num);
        String zero = "";
        if(s.length() != 4) {
            for(int i = 0 ; i<4-s.length(); i++)
                zero += "0";
        }
        zero += s;
        s = zero;
        String temp = "";
        temp += s.toCharArray()[s.length()-1];
        for(int i = 0; i<s.length()-1; i++) {
            temp += s.toCharArray()[i];
        }
        int n = Integer.parseInt(temp);
        return n;
    }
}
