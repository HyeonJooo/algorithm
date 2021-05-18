import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 20;
        System.out.println(solution(n));

    }
    public static int solution(int n) {
        int ans = 0;
        while(n != 0) {
            if(n%2==0) {
                n /= 2;
            }
            else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}
