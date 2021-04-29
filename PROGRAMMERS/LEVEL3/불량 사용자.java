import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] user = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user,ban));
//        System.out.println();
//
//        for(int i = 0; i<list.size(); i++) {
//            for(int j = 0; j<list.get(i).length; j++) {
//                System.out.print(list.get(i)[j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static int answer = 0;
    public static ArrayList<String[]> list = new ArrayList<String[]>();

    public static int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        boolean[] visit = new boolean[user_id.length];
        String[] output = new String[user_id.length];
        combination(user_id, banned_id, output, visit, 0, user_id.length, banned_id.length);
        return answer;
    }

    static void combination(String[] user_id, String[] banned_id, String[] output, boolean[] visit, int start, int n, int r) {
        if(start == r) {
            ban(output, banned_id, visit, r); //조합으로 뽑힌 id들이 ban조건과 맞는지 확인
            return;
        }

        for(int i = 0; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                output[start] = user_id[i];
                combination(user_id, banned_id, output, visit, start+1, n, r);
                visit[i] = false;
            }
        }
    }

    static void ban(String[] output, String[] banned_id, boolean[] visit, int n) {
        boolean[] check = new boolean[banned_id.length];
        boolean isPossible = true;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j< banned_id.length; j++) {
                if(!check[j]) {
                    if(checkBan(output[i], banned_id[j])) {
                        check[j] = true;
                        break;
                    }

                    else {
                        isPossible = false;
                        break;
                    }
                }
            }
        }
        String[] temp = output.clone();
        boolean[] answerCheck;
        boolean ch = true;
        if(isPossible) {
            //list에 중복이 없으면 answer++, list에 추가
            //list에 중복된 값 있으면 answer++하지말고 빠져나감.
            for(int i = 0; i<list.size(); i++) {
                answerCheck = new boolean[n];
                boolean con = true;
                int cnt = 0;

                for(int j = 0; j< n; j++) {
                    for(int k = 0; k< n; k++) {
                        if(list.get(i)[k].equals(output[j])) {
                            answerCheck[j] = true;
                            cnt++;
                            break;
                        }
                        else
                            continue;
                    }
                }
                if(cnt == n) {
                    ch = false;
                    break;
                }
            }

            if(ch) {
                answer++;
                list.add(temp);
            }
        }

    }

    static boolean checkBan(String user, String ban) {
        if(user.length() != ban.length())
            return false;

        for(int i = 0; i<ban.length(); i++) {
            if(ban.toCharArray()[i] == user.toCharArray()[i])
                continue;
            else if(ban.toCharArray()[i] == '*')
                continue;
            else
                return false;
        }
        return true;
    }

}
