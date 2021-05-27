
//아래 코드는 효율성 실패.
//combination말고 다른 방법 필요

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         int n = 3;
//         int k = 2;
//         int[] ans = solution(n,k);
//         for(int i = 0; i<ans.length; i++) {
//             System.out.print(ans[i] + " ");
//         }
//     }
//     static long cnt;
//     static int[] answer;
//     static boolean ch = false;
//     public static int[] solution(int n, long k) {
//         answer = new int[n];
//         int[] arr = new int[n+1];
//         int[] output = new int[n+1];
//         cnt = 0;

//         for(int i =1; i<=n; i++) {
//             arr[i] = i;
//         }
//         boolean[] visit = new boolean[n+1];
//         combination(k, arr, output, visit, 0, n, n);
//         return answer;
//     }

//     static void combination(long k, int[] arr, int[] output, boolean[] visit, int start, int n, int r) {
//         if(start == r) {
//             cnt++;
//             if(cnt == k) {
//                 for(int i = 0; i<r; i++) {
//                     answer[i] = output[i];
//                 }
//                 ch = true;
//             }
//             return;
//         }

//         for(int i = 1; i<=n; i++) {
//             if(!visit[i]) {
//                 visit[i] = true;
//                 output[start] = arr[i];
//                 combination(k, arr, output, visit, start+1, n, r);
//                 if(ch)
//                     return;
//                 visit[i] = false;
//             }
//         }
//     }
// }
