import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();

            int k = 0;
            for (int j = 0; j < N / 10 + 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int cur = Integer.parseInt(st.nextToken());
                    arr.add(cur);

                    if (k % 2 == 0) {
                        Collections.sort(arr);
                        ans.add(arr.get(k / 2));
                    }
                    k++;
                }
            }

            System.out.println(Math.round((float) N / 2));
            for (int j = 1; j < ans.size()+1; j++) {
                System.out.print(ans.get(j-1) + " ");
                if (j % 10 == 0) System.out.println();
            }
            System.out.println();
        }
    }
}
