import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[][] arr = {{"a","d","1"},{"b","d","2"},
                {"a","d","2" }};
        System.out.println(solution(arr));

    }

    static int answer = 0;
    static ArrayList<String> list = new ArrayList<>();

    public static int solution(String[][] relation) {
        boolean[] visit = new boolean[relation[0].length]; //조합뽑는 용도

        for(int i = 1; i<=relation[0].length; i++) {
            combination(relation, visit, 0, relation[0].length, i);
        }
        return answer;
    }

    static void combination(String[][] relation, boolean[] visit, int start, int n, int r) {
        if(r == 0) { 
            Set<String> set = new HashSet<>();
            String temp = "";
            for(int i = 0 ; i<n; i++) {
                if(visit[i]) {
                    temp += Integer.toString(i);
                    temp += " ";
                }
            }

            for(int i = 0; i<list.size(); i++) {
                boolean ch = false;
                String[] st = list.get(i).split(" ");
                for(int j = 0 ; j<st.length; j++) {
                    if(!temp.contains(st[j])) {
                        ch = true;
                        break;
                    }
                }
                if(!ch)
                    return;
            }

            for(int i = 0 ; i<relation.length; i++) {
                String word = "";
                for(int j = 0; j<relation[0].length; j++) {
                    if(visit[j]) {
                        word += relation[i][j];
                        word += " ";
                    }
                }
                set.add(word);
            }
            if(set.size() != relation.length)
                return;
            else {
                list.add(temp);
                answer++;
            }
            return;
        }

        for(int i = start; i<n; i++) {
            visit[i] = true;
            combination(relation, visit, i+1, n, r-1);
            visit[i] = false;
        }
    }
}
