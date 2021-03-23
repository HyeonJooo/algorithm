import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer = "";
        String temp = "";
        String rev = "";
        String[] st = s.split("");
        for(int i = 0 ; i<s.length(); i++) {
            rev = "";
            temp = "";

            if(st[i].equals("<")) {
                while(true) {
                    if(st[i].equals(">")) {
                        answer += st[i];
                        break;
                    }
                    answer += st[i];
                    i++;
                }
            }
            else {
                while(true) {
                    if(i == s.length()) {
                        rev = new StringBuffer(temp).reverse().toString();
                        break;
                    }
                    if(st[i].equals("<")) {
                        rev = new StringBuffer(temp).reverse().toString();
                        i--;
                        break;
                    }
                    if(st[i].equals(" ")) {
                        rev = new StringBuffer(temp).reverse().toString();
                        rev += " ";
                        break;
                    }
                    temp += st[i];
                    i++;
                }

                answer += rev;
                temp = "";
            }
        }
        System.out.println(answer);
    }
}
