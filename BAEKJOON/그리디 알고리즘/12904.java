import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer(br.readLine());
        StringBuffer t = new StringBuffer(br.readLine());

        while(t.length() > s.length()) {
            if(t.charAt(t.length()-1) == 'A')
                t.deleteCharAt(t.length()-1);

            else {
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }
        if(t.toString().equals(s.toString()))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
