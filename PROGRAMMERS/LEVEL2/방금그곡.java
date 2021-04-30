import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String m = "A#";
        String[] arr = {"13:00,13:02,HAPPY,B#A#"};
        System.out.println(solution(m,arr));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int max = -1;

        for(int i = 0 ; i< musicinfos.length; i++) {
            String[] st = musicinfos[i].split(",");
            String[] time1 = st[0].split(":");
            String[] time2 = st[1].split(":");
            String[] songinfo = st[3].split("");

            int playTime = (Integer.parseInt(time2[0])-Integer.parseInt(time1[0]))*60 + (Integer.parseInt(time2[1])-Integer.parseInt(time1[1]));
            String song = "";

            for(int a = 0 ; a<playTime; a++) {
                song += songinfo[a% songinfo.length];
                if(songinfo[a% songinfo.length].equals("#"))
                    playTime++;
                else if(a == playTime-1 && songinfo[(a+1) % songinfo.length].equals("#"))
                    song += "#";
            }

            if(song.contains(m)) {
                int idx = song.indexOf(m);
                List<Integer> list = new ArrayList<>();

                while(idx != -1) {
                    list.add(idx);
                    idx = song.indexOf(m, idx+m.length());
                }

                for(int k = 0; k<list.size(); k++) {
                    if(list.get(k)+m.length() >= song.length() || song.toCharArray()[list.get(k)+m.length()] != '#') {
                        if(max < playTime) {
                            answer = st[2];
                            max = playTime;
                        }
                    }
                }
            }
        }

        if(answer == "")
            answer = "(None)";
        return answer;
    }
}
