import java.io.*;
import java.util.*;
public class Main {
    static int ans = Integer.MAX_VALUE;
    static int[][] info;
    static int[][] tmpArr;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n+1][m+1];

        for(int i = 1 ; i<=n; i++) {
            for(int j =1 ; j<=m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        tmpArr = arrCopy(arr);
        info = new int[k][3];
        int[] per = new int[k];

        for(int i = 0; i<k; i++) {
            info[i][0] = sc.nextInt();
            info[i][1] = sc.nextInt();
            info[i][2] = sc.nextInt();
            per[i] = i;
        }
        permutation(per, 0, k,k);

        System.out.println(ans);
    }

    static int[][] rotate(int[][] rotateArr, int r, int c, int s) {
        int num1 = r-s;
        int num2 = c-s;
        int num3 = r+s;
        int num4 = c+s;

        while(true) {
            if(num1 == r && num2 == c)
                break;

            int tmp1 = rotateArr[num1][num4];
            int tmp2 = rotateArr[num3][num4];
            int tmp3 = rotateArr[num3][num2];

            for(int i = num4; i>num2; i--) {
                rotateArr[num1][i] = rotateArr[num1][i-1];
            }
            for(int i = num3; i>num1; i--) {
                if(i == num1+1) {
                    rotateArr[i][num4] = tmp1;
                    break;
                }
                rotateArr[i][num4] = rotateArr[i-1][num4];
            }
            for(int i = num2; i<num4; i++) {
                if(i == num4-1) {
                    rotateArr[num3][i] = tmp2;
                    break;
                }
                rotateArr[num3][i] = rotateArr[num3][i+1];
            }
            for(int i = num1; i<num3; i++) {
                if(i == num3-1) {
                    rotateArr[i][num2] = tmp3;
                    break;
                }
                rotateArr[i][num2] = rotateArr[i+1][num2];
            }

            num1++;
            num2++;
            num3--;
            num4--;
        }
        return rotateArr;
    }

    static int cal(int[][] arr) {
        int min = Integer.MAX_VALUE;

        for(int i = 1; i<arr.length; i++) {
            int sum = 0;
            for(int j = 1; j<arr[0].length; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    static int[][] arrCopy(int[][] arr) {
        int[][] tmp = new int[arr.length][arr[0].length];
        for(int i = 1; i<arr.length; i++) {
            for(int j = 1; j<arr[0].length; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    static void permutation(int[] perArr, int depth, int n, int r) {
        if(depth == r) {
            for(int i = 0; i<perArr.length; i++) {
                tmpArr = rotate(tmpArr, info[perArr[i]][0],info[perArr[i]][1],info[perArr[i]][2]);
            }
            ans = Math.min(ans, cal(tmpArr));
            tmpArr = arrCopy(arr);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(perArr, depth, i);
            permutation(perArr, depth + 1, n, r);
            swap(perArr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
