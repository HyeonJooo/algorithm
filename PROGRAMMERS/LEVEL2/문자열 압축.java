import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = "xxxz";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        if(s.length() == 1)
            return 1;
        int answer = Integer.MAX_VALUE;
        String temp = "";
        String next = "";
        String word = "";
        int wordCnt = 0;
        int ansCnt = 1;
        boolean ch1 = false;

        for(int i = 1; i<=s.length()/2; i++) { //i개씩 압축
            word = "";

            for(int j = 0; j<s.length(); j++) {
                ch1 = false;
                wordCnt = 0;
                temp = "";
                while (wordCnt < i) {
                    temp += s.charAt(j);
                    j++;
                    wordCnt++;
                }

                int k = j;
                ansCnt = 1;

                while (k < s.length()){
                    next = "";
                    wordCnt = 0;

                    while (wordCnt < i) {
                        if(k == s.length())
                            break;
                        next += s.charAt(k);
                        k++;
                        wordCnt++;
                    }

                    if(temp.equals(next)) {
                        ansCnt++;
                        ch1 = true;
                    }

                    else {
                        break;
                    }
                }

                if(ansCnt > 1) {
                    word += Integer.toString(ansCnt) + temp;
                }
                else
                    word += temp;

                if(!ch1 && k == s.length()) {
                    word += next;
                    break;
                }

                if(k == s.length() && !temp.equals(next)) {
                    word += next;
                    break;
                }

                else if(k == s.length() && temp.equals(next)) {
                    break;
                }
                j = k-i-1;
            }
            answer = Math.min(answer, word.length());
        }
        return answer;
    }
}
