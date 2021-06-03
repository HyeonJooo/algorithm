import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[][] arr = {{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}};
        String[] ans = solution(arr);
        for(int i = 0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }

    static boolean[] visit;
    static ArrayList<String> list;
    static String[] answer;
    static boolean br = false;
    public static String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        visit = new boolean[tickets.length];
        list = new ArrayList<>();

        Arrays.sort(tickets, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
                return o1[0].compareTo(o2[0]);
            }
        });
        list.add("ICN");
        for(int i = 0; i<tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                dfs(tickets, tickets[i][1], i);
                if(br)
                    break;
                visit = new boolean[tickets.length];
                list = new ArrayList<>();
                list.add("ICN");
            }
        }

        return answer;
    }

    static void dfs(String[][] arr, String to, int idx) {
        list.add(to);
        visit[idx] = true;

        if(check(visit)) {
            for(int i = 0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
            br = true;
            return;
        }

        for(int i = 0 ; i<arr.length; i++) {
            if(arr[i][0].equals(to) && !visit[i]) {
                dfs(arr, arr[i][1], i);
                if(br)
                    break;
                visit[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    static boolean check(boolean[] visit) {
        for(int i = 0; i<visit.length; i++) {
            if(!visit[i])
                return false;
        }
        return true;
    }
}
