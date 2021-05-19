import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        int a = 1;
        int b = 2;
        System.out.println(solution(n,a,b));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;
        while(true) {
            if((a%2==0 && a-1==b) || (a%2!=0 && a+1==b))
                break;

            if(a%2 == 0)
                a /= 2;
            else {
                a /= 2;
                a++;
            }

            if(b%2 == 0)
                b /= 2;
            else {
                b /= 2;
                b++;
            }
            answer++;
        }
        return answer+1;
    }
}
