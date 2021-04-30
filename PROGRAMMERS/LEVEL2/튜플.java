import java.io.*;
import java.util.*;
class Solution {
    public static int[] solution(String s) {
        int[] answer = {};
        ArrayList<String[]> list = new ArrayList<>();
        s = s.replaceAll("[{]", "");
        String[] st = s.split("}");

        String[] temp;
        for(int i = 0; i<st.length; i++) {
            temp = st[i].split(",");
            if(i == 0) {
                list.add(temp);
            }

            else {
                String[] temp2 = Arrays.copyOfRange(temp, 1, temp.length);
                list.add(temp2);
            }
        }

        int size = 1;
        int idx = 0;
        List<String> ans = new ArrayList<>();

        while(true) {
            if(size > list.size())
                break;

            if(list.get(idx).length == size) {
                for(int i = 0; i<size; i++) {
                    if(!ans.contains(list.get(idx)[i])) {
                        ans.add(list.get(idx)[i]);
                        break;
                    }
                }
                size++;
                idx = 0;
                continue;
            }
            idx++;
        }

        answer = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++) {
            answer[i] = Integer.parseInt(ans.get(i));
        }
        return answer;
    }
}
