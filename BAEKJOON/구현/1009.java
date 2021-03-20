import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=0; tc<t; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int num1 = a%10;
            int num2 = 0;
            int ans = 1;
            if(num1 == 0 || num1 == 1 || num1 == 5 || num1 == 6)
                ans = num1;

            else if(num1 == 4 || num1 == 9) {
                num2 = b % 2;
                if(num2 == 0)
                    num2 = 2;
            }

            else {
                num2 = b % 4;
                if(num2 == 0)
                    num2 = 4;
            }
            for(int i = 0; i<num2; i++) {
                ans = (ans*a) % 10;
            }
            if(ans == 0)
                ans = 10;
            System.out.println(ans);
        }
    }
}
