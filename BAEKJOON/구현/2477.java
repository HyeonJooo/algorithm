import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[][] arr = new int[6][2];
        int max1 = 0;
        int max2 = 0;

        for(int i = 0; i<6; i++) {
            for(int j = 0; j<2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i<6; i++) {
            if(i % 2 == 0) {
                if(max1 < arr[i][1])
                    max1 = arr[i][1];
            }
            else {
                if(max2 < arr[i][1])
                    max2 = arr[i][1];
            }
        }

        int ww = 0;
        int hh = 0;
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                if (max2 == arr[(i + 5) % 6][1] + arr[(i + 1) % 6][1]) {
                    ww = arr[i][1];
                }
            } else {
                if (max1 == arr[(i + 5) % 6][1] + arr[(i + 1) % 6][1]) {
                    hh = arr[i][1];
                }
            }
        }

        int ans = (max1*max2) - (ww*hh);
        System.out.println(ans*k);
    }
}
