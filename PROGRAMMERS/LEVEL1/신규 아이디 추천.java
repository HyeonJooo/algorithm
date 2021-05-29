import java.util.*;
class Solution {
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase(Locale.ROOT); //1
        new_id = new_id.replaceAll("[^0-9a-z_.-]", "");//2
        new_id = new_id.replaceAll("[.]{2,}",".");//3
        new_id = new_id.replaceAll("^[.]|[.]$", "");//4
        if(new_id.equals(""))//5
            new_id = "a";

        //6
        if(new_id.length()>15) {
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        //7
        if(new_id.length()<=2) {
            while(new_id.length()<3) {
                new_id += new_id.charAt(new_id.length()-1);
            }
        }
        return new_id;
    }
}

// import java.util.Locale;

// public class Main {

//     public static void main(String[] args) {
//         System.out.println(solution("=.="));
//     }

//     public static String solution(String new_id) {
//         //1.대문자를 소문자로
//         new_id = new_id.toLowerCase(Locale.ROOT);

//         //2.소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
//         String[] st;
//         st = new_id.split("");
//         String id1 = "";
//         for(int i = 0 ; i<st.length; i++) {
//             //알파벳 소문자인지 검사
//             int num = 0;
//             num = st[i].charAt(0);
//             if(num >= 97 && num <=122) {
//                 id1 += st[i];
//             }

//             else if(num >= 48 && num <=57) {
//                 id1 += st[i];
//             }

//             else if(st[i].equals("-") || st[i].equals("_") || st[i].equals(".")) {
//                 id1 += st[i];
//             }
//             else
//                 continue;
//         }

//         //3.연속된 .을 하나의 .로 치환
//         String[] st2;
//         st2 = id1.split("");
//         String id2 = "";
//         boolean check = true;
//         for(int i = 0; i<st2.length; i++) {
//             if(!st2[i].equals(".")) {
//                 if(check == false)
//                     id2 += ".";
//                 id2 += st2[i];
//                 check = true;
//             }
//             else
//                 check = false;
//         }
//         if(check==false)
//             id2 += ".";

//         //4. 마침표가 처음이나 끝에 위치하면 제거
//         String[] st3;
//         st3 = id2.split("");
//         String id3 = "";
//         for(int i = 0; i<st3.length; i++) {
//             if(i==0 && st3[i].equals(".")) {
//                 continue;
//             }
//             else if(i==st3.length-1 && st3[i].equals(".")) {
//                 continue;
//             }
//             else
//                 id3 += st3[i];
//         }

//         //5.빈문자열이라면 new_id에 a대입
//         if(id3 == "")
//             id3 = "a";

//         //6. new_id길이가 16이상이면 첫 15개 제외한 나머지를 모두 제거
//         String id4 = "";
//         if(id3.length() >= 16) {
//             String[] st4;
//             st4 = id3.split("");
//             for(int i = 0; i<15; i++) {
//                 if(i==14 && st4[i].equals("."))
//                     continue;
//                 id4 += st4[i];
//             }
//         }
//         else
//             id4 = id3;

//         //7.new_id길이가 2 이하면, 마지막 문자를 길이가 3이 될때까지 반복해서 끝에 붙인다.
//         String id5 = id4;
//         if(id4.length()<=2) {
//             String[] st5;
//             st5 = id4.split("");
//             String last = st5[st5.length-1];

//             while (id5.length() != 3) {
//                 id5 += last;
//             }
//         }

//         String answer = id5;
//         return answer;
//     }
// }
