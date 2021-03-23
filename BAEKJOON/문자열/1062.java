import java.io.*;
import java.util.*;

public class Main {
    static String[] word;
    static int ans = 0;
    static HashMap<Character, Boolean> map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //단어개수
        int k = sc.nextInt(); //가르칠 단어 개수
        word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = sc.next();
        }
        if (k < 5) {
            System.out.println(0);
            System.exit(0);
        }

        int num = k - 5;
        map = new HashMap<>();
        char[] alphabet = new char[26];
        for(int i = 0 ; i<26; i++) {
            alphabet[i] = (char)(i+97);
            if(i==0 || i==2 || i==8 || i==13 || i==19)
                map.put(alphabet[i], true);
            else
                map.put(alphabet[i], false);
        }

        for(int i = 0 ; i<n; i++) {
            word[i] = word[i].substring(4,word[i].length()-4);
        }

        combination(alphabet, 0, 26, num);
        System.out.println(ans);
    }

    static void combination(char[] arr, int start, int n, int r) {
        if(r == 0) {
            ans = Math.max(ans, isReadableWord());
//            ans++;
            return;
        }

        for(int i=start; i<n; i++) {
            //a,c,i,n,t 제외하고 하나씩 배움
            if(i==0 || i==2 || i==8 || i==13 || i==19)
                continue;
            map.put(arr[i], true);
            combination(arr, i + 1, n, r - 1);
            map.put(arr[i], false);
        }
    }

    //읽을 수 있는 단어가 몇개인지 확인하는 함수
    static int isReadableWord() {
        boolean read = false;
        int cnt = 0;
        for(int i =0 ; i<word.length; i++) {
            read = false;
            for(int j = 0 ; j<word[i].length(); j++) {
                if(map.get(word[i].toCharArray()[j]))
                    read = true;
                else {
                    read = false;
                    break;
                }
            }
            if(read || word[i].length()==0)
                cnt++;
        }
        return cnt;
    }
}
