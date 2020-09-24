import java.io.*;
import java.util.*;
public class Main {	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for(int i = 0 ; i<n; i++) {
        	d[i] = sc.nextInt();
        }
        int budget = sc.nextInt();
        Arrays.sort(d);
        int cnt = 0;
        for(int i = 0 ; i<d.length; i++) {
        	budget -= d[i];
        	if(budget<0)
        		break;
        	cnt++;
        }
        System.out.println(cnt);
    }
}
