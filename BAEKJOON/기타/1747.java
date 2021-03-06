import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[1005001];

        for(int i = 2; i<=1005000; i++) {
            check[i] = true;
        }

        //true=소수
        for(int i = 2; i*i<=1005000; i++) {
            for(int j = i*i; j<=1005000; j+=i) {
                check[j] = false;
            }
        }

        for(int i = n; i<=1005000; i++ ){
            if(check[i]) { //소수이면서
                String s = Integer.toString(i);
                String reverse = new StringBuffer(s).reverse().toString();
                if(s.equals(reverse)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
