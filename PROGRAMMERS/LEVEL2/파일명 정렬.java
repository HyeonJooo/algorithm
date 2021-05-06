import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] ans = solution(arr);
        for(int i = 0 ; i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String h1 = o1.split("[0-9]")[0];
                String h2 = o2.split("[0-9]")[0];
                int num = h1.toLowerCase(Locale.ROOT).compareTo(h2.toLowerCase(Locale.ROOT));

                if(num == 0) {
                    num = number(o1,h1) - number(o2,h2);
                }
                return num;
            }
        });
        return files;
    }

    public static int number(String s, String h) {
        s = s.replace(h,"");
        String word = "";
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c) && word.length()<5) {
                word += c;
            }
            else
                break;
        }
        return Integer.parseInt(word);
    }
}
