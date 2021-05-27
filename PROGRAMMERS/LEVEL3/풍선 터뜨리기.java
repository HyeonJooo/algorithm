import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        System.out.println(solution(a));
    }

    static int[] mintree;
    public static int solution(int[] a) {
        if(a.length < 3)
            return a.length;

        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        arr.add(0);

        for(int i = 0 ; i<a.length; i++) {
            arr.add(i+1, a[i]);
        }
        mintree = new int[a.length*4];
        init_min(1,a.length,1,arr);

        for(int i = 2; i<a.length; i++) {
            int leftMin = min_num(1, a.length, 1, 1, i-1);
            int rightMin = min_num(1, a.length, 1, i+1, a.length+1);
//            System.out.println(leftMin + " " + rightMin);
            if(leftMin<a[i-1] && rightMin<a[i-1])
                continue;
            else
                answer++;
        }

        return answer + 2;
    }

    static int init_min(int start, int end, int node, List<Integer> space) {
        if(start == end)
            return mintree[node] = space.get(start);

        int mid = (start + end) / 2;

        return mintree[node] = Math.min(init_min(start, mid, node*2, space),
                init_min(mid+1, end, node*2+1, space));
    }

    static int min_num(int start, int end, int node, int left, int right) {
        if(start > right || end < left)
            return Integer.MAX_VALUE;

        if(left <= start && end <= right)
            return mintree[node];

        int mid = (start + end) / 2;

        return Math.min(min_num(start, mid, node*2, left, right),
                min_num(mid+1, end, node*2+1, left, right));
    }
}


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
