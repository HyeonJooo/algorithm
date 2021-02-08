import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        if(n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        int ans = -1;

        for(int i = -1; i<=1; i++) {
            for(int j = -1; j<=1; j++) {
                int cnt = 0;

                if(i != 0)
                    cnt++;
                if(j != 0)
                    cnt++;

                int first = arr[0] + i;
                int second = arr[1] + j;
                int diff = second - first;

                boolean check = true;
                int num = second;

                for(int k = 2; k<n; k++) {
                    num += diff;

                    if(arr[k] == num)
                        continue;

                    else if(arr[k] + 1 == num || arr[k] - 1 == num)
                        cnt++;

                    else {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    if(ans == -1 || cnt < ans)
                        ans = cnt;
                }
            }
        }
        System.out.println(ans);
    }
}
