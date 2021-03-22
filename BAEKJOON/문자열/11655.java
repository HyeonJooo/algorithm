import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer = "";

        for(int i = 0; i<s.length(); i++) {
            int num = (int)s.toCharArray()[i];
            if(num>=65 && num<=77)
                num += 13;

            else if(num>=78 && num<=90)
                num -= 13;

            else if(num>=97 && num<=109)
                num += 13;

            else if(num>=110 && num<=122)
                num -= 13;

            char ch = (char)num;
            answer += ch;
        }
        System.out.println(answer);
    }
}
