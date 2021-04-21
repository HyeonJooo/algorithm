import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n+m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = n; i<n+m; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        for(int i = 0 ; i<arr1.length; i++) {
            bw.write(arr1[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
