import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> wordList = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            String s = sc.next();
            if(!wordList.contains(s))
                wordList.add(s);
        }

        String[] word = new String[wordList.size()];
        for(int i = 0; i< wordList.size(); i++) {
            word[i] = wordList.get(i);
        }

        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int cnt = 0;

        for(int i = 0; i<word.length-1; i++) {
            for(int j = i+1; j<word.length; j++) {
                if(word[j].startsWith(word[i])) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(word.length - cnt);
    }
}
