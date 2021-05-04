import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = "ABABABABABABABAB";
        int[] ans = solution(s);
        for(int i = 0 ; i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A",1);map.put("B",2);map.put("C",3);map.put("D",4);map.put("E",5);
        map.put("F",6);map.put("G",7);map.put("H",8);map.put("I",9);map.put("J",10);
        map.put("K",11);map.put("L",12);map.put("M",13);map.put("N",14);map.put("O",15);
        map.put("P",16);map.put("Q",17);map.put("R",18);map.put("S",19);map.put("T",20);
        map.put("U",21);map.put("V",22);map.put("W",23);map.put("X",24);map.put("Y",25);map.put("Z",26);

        String[] st = msg.split("");
        String word = "";
        String last = "Z";
        boolean check = false;

        for(int i = 0 ; i<msg.length(); i++) {
            word += st[i];
            if(map.containsKey(word)) {
                int idx = i+1;
                while(true) {
                    if(idx >= msg.length()) {
                        list.add(map.get(word));
                        check = true;
                        break;
                    }

                    word += st[idx];
                    if(!map.containsKey(word)) {
                        map.put(word, map.get(last)+1); //없으면 사전에 등록
                        last = word;
                        word = word.substring(0, word.length()-1);
                        list.add(map.get(word)); //정답에 색인번호 출력
                        word = "";
                        i = idx-1;
                        break;
                    }
                    else
                        idx++;
                }
                if(check)
                    break;
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0 ; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }

}
