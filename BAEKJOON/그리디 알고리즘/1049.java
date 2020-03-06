import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] pack = new int[m];
        int[] one = new int[m];
        for(int i = 0 ; i<m; i++) {
        	pack[i] = sc.nextInt();
        	one[i] = sc.nextInt();
        }
        Arrays.sort(pack);
        Arrays.sort(one);
        
        System.out.println(Math.min(Math.min(pack[0]*(n/6) + one[0]*(n%6), one[0]*n),pack[0]*(n/6+1)));        
    }
}
