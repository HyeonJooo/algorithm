import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String origin = word;
        word = word.replaceAll("[a,e,i,o,u][p][a,e,i,o,u]","*");
        String answer = "";
        int idx = 0;
        for(int i = 0; i<word.length(); i++) {
            answer += origin.charAt(idx);
            if(word.charAt(i) == '*') {
                idx += 3;
            }
            else
                idx++;
        }
        System.out.println(answer);
    }
}
