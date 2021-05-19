import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r = 100;
        int c = 97;
        int[][] arr = {{1,1,100,97}};
        int[] ans = solution(r,c,arr);
        for(int i = 0; i<ans.length; i++)
            System.out.println(ans[i]);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int num = 1;
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<columns; j++) {
                arr[i][j] = num++;
            }
        }

        for(int i = 0; i<queries.length; i++) {
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int min = Integer.MAX_VALUE;

            //윗줄 오른쪽으로
            int temp1 = arr[x1][y2];
            for(int a = y2; a>y1; a--) {
                arr[x1][a] = arr[x1][a-1];
                min = Math.min(min, arr[x1][a]);
            }

            //오른쪽줄 아래로
            int temp2 = arr[x2][y2];
            for(int a = x2; a>x1+1; a--) {
                arr[a][y2] = arr[a-1][y2];
                min = Math.min(min, arr[a][y2]);
            }
            arr[x1+1][y2] = temp1;

            //아랫줄 왼쪽으로
            int temp3 = arr[x2][y1];
            for(int a = y1; a<y2-1; a++) {
                arr[x2][a] = arr[x2][a+1];
                min = Math.min(min, arr[x2][a]);
            }
            arr[x2][y2-1] = temp2;

            //왼쪽줄 위로
            for(int a = x1; a<x2-1; a++) {
                arr[a][y1] = arr[a+1][y1];
                min = Math.min(min, arr[a][y1]);
            }
            arr[x2-1][y1] = temp3;
            min = Math.min(min, Math.min(temp1, Math.min(temp2,temp3)));
            answer[i] = min;
        }
        return answer;
    }
}
