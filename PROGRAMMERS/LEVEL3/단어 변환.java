import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String b = "hit";
        String t = "cog";
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(b,t,arr));
    }

    static List<String> list = new ArrayList<>();
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        for(int i = 0 ; i<words.length; i++) {
            list.add(words[i]);
        }

        if(!list.contains(target))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i<size; i++) {
                String word = queue.poll();

                List<Integer> removeList = new ArrayList<>();
                for(int j = 0; j<list.size(); j++) {
                    if(check(word, list.get(j))) {
                        if(list.get(j).equals(target))
                            return answer+1;

                        queue.add(list.get(j));
                        removeList.add(j);
                    }
                }
                for(int j = 0; j<removeList.size(); j++) {
                    int num = removeList.get(j);
                    num = num-j;
                    list.remove(num);
                }
            }
            answer++;
        }

        return answer;
    }

    static boolean check(String word, String inWords) {
        int cnt = 0;
        for(int i = 0 ; i<word.length(); i++) {
            if(word.charAt(i) != inWords.charAt(i))
                cnt++;
        }
        if(cnt == 1)
            return true;
        else
            return false;
    }
}
