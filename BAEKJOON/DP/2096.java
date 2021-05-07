import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] beforeMin = new int[3];
        int[] beforeMax = new int[3];
        int[] curMin = new int[3];
        int[] curMax = new int[3];

        for(int i = 0 ; i<n; i++) {
            for(int j = 0 ; j<3; j++) {
                int num = sc.nextInt();
                curMax[j] = curMin[j] = num;
                curMax[j] += Math.max(beforeMax[1], (j==1)?Math.max(beforeMax[0], beforeMax[2]) : beforeMax[j]);
                curMin[j] += Math.min(beforeMin[1], (j==1)?Math.min(beforeMin[0], beforeMin[2]) : beforeMin[j]);
            }
            beforeMax = Arrays.copyOf(curMax, curMax.length);
            beforeMin = Arrays.copyOf(curMin, curMin.length);
        }
        Arrays.sort(beforeMax);
        Arrays.sort(beforeMin);
        System.out.println(beforeMax[2] + " " + beforeMin[0]);
    }
}
