import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = "a b  c ";
        System.out.println(solution(s));

    }
    public static String solution(String s) {
        String answer = "";
        String[] st = s.split(" ");
        if(s.substring(s.length()-1, s.length()).equals(" "))
            st[st.length-1] += " ";
        for(int i = 0; i<st.length; i++) {
            if(st[i].equals("")) {
                answer += " ";
                continue;
            }
            String first = Character.toString(st[i].charAt(0));
            String second = st[i].substring(1, st[i].length());
            first = first.toUpperCase(Locale.ROOT);
            second = second.toLowerCase(Locale.ROOT);
            st[i] = first + second;
            answer += st[i];
            answer += " ";
        }
        answer = answer.replaceAll("[\\s]$", "");
        return answer;
    }
}
