import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[n+1][n+1];
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            arr[i+1] = Integer.parseInt(st.nextToken());
        }

        //1글자는 무조건 펠린드롬
        for(int i = 1; i<=n; i++) {
            check[i][i] = true;
        }

        //2글자는 앞뒤 단어 똑같으면 펠린드롬
        for(int i = 1; i<n; i++) {
            if(arr[i] == arr[i+1]) {
                check[i][i+1] = true;
                check[i+1][i] = true;
            }
        }

        //3글자 이상부터는 맨앞뒤같고, 그 사이가 펠린드롬이면 펠린드롬
        for(int i = 2; i<n; i++) {
            for(int j = 1; j<=n-i; j++) {
                if(arr[j] == arr[j+i] && check[j+1][j+i-1]) {
                    check[j][j+i] = true;
                    check[j+i][j] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(check[s][e])
                sb.append("1\n");
            else
                sb.append("0\n");
        }
        System.out.print(sb);
    }
}
