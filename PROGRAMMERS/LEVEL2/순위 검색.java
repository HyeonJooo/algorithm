import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] q = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        int[] ans = solution(info,q);
        for(int i = 0 ; i<ans.length; i++)
            System.out.print(ans[i] + " ");

    }
    static Map<String, List<Integer>> map = new HashMap<>();
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(int i = 0 ; i<info.length; i++) {
            boolean[] visit = new boolean[4];
            String[] arr = info[i].split(" ");
            for(int j = 0; j<=4; j++) {
                //info[i]에 해당하는 모든 쿼리를 생성
                combination(arr, visit, 0, 4, j);
            }
        }
        Iterator<String> it= map.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            List<Integer> li=map.get(key);
            Collections.sort(li);
        }

        for(int i = 0; i< query.length; i++) {
            int score = Integer.parseInt(query[i].replaceAll("[^0-9]", ""));
            String op = query[i].replaceAll("[0-9]", "");
            op = op.replaceAll(" and ", "");
            op = op.replaceAll("-", "");
            op = op.replaceAll("[\\s]$", "");

            //map에서 op의 list값들 중 score 이상인것들을 이분탐색으로 찾기
            if(!map.containsKey(op)) answer[i] = 0;
            else {
                List<Integer> list = map.get(op);
                int left = 0;
                int right = list.size()-1;

                while(left<=right) {
                    int mid = (left+right)/2;
                    if(list.get(mid) < score)
                        left = mid+1;
                    else
                        right = mid-1;
                }
                answer[i] = list.size() - left;
            }
        }
        return answer;
    }

    static void combination(String[] arr, boolean[] visit, int start, int n, int r) {
        if(r == 0) {
            String s = "";
            for(int a = 0; a<n; a++) {
                if(!visit[a])
                    s += arr[a];
            }
            if(map.containsKey(s))
                map.get(s).add(Integer.parseInt(arr[4]));
            else {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(arr[4]));
                map.put(s, list);
            }
            return;
        }

        for(int i = start; i<n; i++) {
            visit[i] = true;
            combination(arr, visit, i+1, n, r-1);
            visit[i] = false;
        }
    }
}
