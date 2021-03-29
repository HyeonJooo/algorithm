import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String[] arr = word.split("");
        int n = sc.nextInt();
        int answer = 0;

        for(int i = 0 ; i<n; i++) {
            String s = sc.next();
            String[] ring = s.split("");
            for(int j = 0; j<10; j++) {
                int idx = j;
                boolean check = false;
                for(int k = 0 ; k<arr.length; k++) {
                    if(idx>9)
                        idx -= 10;
                    if(ring[idx].equals(arr[k]))
                        idx++;
                    else {
                        check = true;
                        break;
                    }
                }
                if(!check) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
