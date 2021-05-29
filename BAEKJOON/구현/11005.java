import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        conversion(n,b);
    }

    static void conversion(int num, int N) {
        StringBuilder sb = new StringBuilder();
        int current = num;

        while(current > 0) {
            if(current % N < 10)
                sb.append(current % N);

            else {
                sb.append((char)(current % N - 10 +'A'));
            }

            current /= N;
        }
        System.out.println(sb.reverse());
    }
}
