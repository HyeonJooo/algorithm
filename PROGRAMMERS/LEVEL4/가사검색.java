
//아래코드: 정확성통과, 효율성1,2,3실패 4,5통과 ->수정필요

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
//         String[] query = {"fro??","????o",  "fr???", "fro???", "pro?"};
//         int[] ans = solution(words,query);
//         for(int i = 0; i<ans.length; i++) {
//             System.out.print(ans[i] + " ");
//         }
//     }

//     public static int[] solution(String[] words, String[] queries) {
//         int[] answer = new int[queries.length];

//         for(int i = 0; i< queries.length; i++) {
//             int querySize = queries[i].length();
//             boolean front = false;

//             if(queries[i].charAt(0) == '?')
//                 front = true;

//             queries[i] = queries[i].replaceAll("[?]", "");
//             int cutSize = querySize - queries[i].length();

//             for(int j = 0; j< words.length; j++) {
//                 if(querySize != words[j].length())
//                     continue;

//                 String temp = words[j];
//                 if(front) {
//                     temp = temp.substring(cutSize, temp.length());
//                 }
//                 else {
//                     temp = temp.substring(0, temp.length()-cutSize);
//                 }
//                 if(temp.equals(queries[i]))
//                     answer[i]++;
//             }
//         }

//         return answer;
//     }
// }
