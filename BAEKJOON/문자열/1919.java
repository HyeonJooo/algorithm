import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0 ; i<s1.length(); i++) {
            arr1[(int)s1.toCharArray()[i]-97]++;
        }
        for(int i = 0 ; i<s2.length(); i++) {
            arr2[(int)s2.toCharArray()[i]-97]++;
        }
        int answer = 0;
        for(int i = 0 ; i<26; i++) {
            if(arr1[i] != arr2[i]) {
                answer += Math.abs(arr1[i]-arr2[i]);
            }
        }
        System.out.println(answer);
    }
}
