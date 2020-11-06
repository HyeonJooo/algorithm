import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int k = sc.nextInt();
       double[] arr = new double[n];
       for(int i = 0 ; i<n; i++) {
    	   arr[i] = sc.nextDouble();
       }
       Arrays.sort(arr);
       double sum = 0;
       for(int i = k; i<n-k; i++) {
    	   sum += arr[i];
       }
       System.out.printf("%.2f\n", sum/(n-2*k));
       double d1 = arr[k];
       d1 *= k;
       double d2 = arr[n-k-1];
       d2 *= k;
       sum += d1 + d2;
//       System.out.println("d1: " + d1);
//       System.out.println("d2: " + d2);
//       System.out.println("sum " + sum);
       System.out.printf("%.2f\n", sum/n);       
    }
}
