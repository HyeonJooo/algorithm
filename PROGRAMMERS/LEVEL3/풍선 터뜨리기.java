
//아래 코드는 시간초과.

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
//         System.out.println(solution(a));
//     }

//     public static int solution(int[] a) {
//         if(a.length < 3)
//             return a.length;

//         int answer = 0;
//         int leftMin = a[0];
//         int rightMin = a[2];
//         int leftIdx = 0;
//         int rightIdx = 2;

//         for(int i = 1 ; i<a.length-1; i++) {
//             int cnt = 0;
//             int cur = a[i];

//             //i기준 왼쪽에 a[i]보다 작은 값이 있는지 확인
//             if(leftIdx >= i) {
//                 leftIdx = i+1;
//                 for(int j = leftIdx; j<i; j++) {
//                     if(a[j] < cur) {
//                         leftMin = Math.min(leftMin, a[j]);
//                         leftIdx = j;
//                         cnt++;
//                         break;
//                     }
//                 }
//             }

//             else {
//                 if(cur > leftMin)
//                     cnt++;

//                 else if(leftMin >= cur) {
//                     for(int j = leftIdx; j<i; j++) {
//                         if(a[j] < cur) {
//                             leftMin = Math.min(leftMin, a[j]);
//                             leftIdx = j;
//                             cnt++;
//                             break;
//                         }
//                     }
//                 }
//             }

//             //i기준 오른쪽에 a[i]보다 작은 값이 있는지 확인
//             if(rightIdx <= i) {
//                 rightIdx = i+1;
//                 for(int j = rightIdx; j<a.length; j++) {
//                     if(a[j] < cur) {
//                         rightMin = Math.min(rightMin, a[j]);
//                         rightIdx = j;
//                         cnt++;
//                         break;
//                     }
//                 }
//             }
//             else {
//                 if(cur > rightMin)
//                     cnt++;

//                 else if(rightMin >= cur) {
//                     for(int j = rightIdx; j<a.length; j++) {
//                         if(a[j] < cur) {
//                             rightMin = Math.min(rightMin, a[j]);
//                             rightIdx = j;
//                             cnt++;
//                             break;
//                         }
//                     }
//                 }
//             }

//             if(cnt != 2)
//                 answer++;
//         }

//         return answer+2;
//     }
// }
