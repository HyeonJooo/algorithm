import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] g = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] p = {400, 600, 150, 600, 500, 500};
        int[] ans = solution(g,p);
        for(int i = 0; i<ans.length; i++)
            System.out.println(ans[i]);

    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> genreInfo = new HashMap<>();
        Map<String, List<Integer>> songInfo = new HashMap<>();

        for(int i = 0; i< genres.length; i++) {
            if(!genreInfo.containsKey(genres[i]))
                genreInfo.put(genres[i], plays[i]);
            else
                genreInfo.put(genres[i], genreInfo.get(genres[i])+plays[i]);

            if(songInfo.containsKey(genres[i]))
                songInfo.get(genres[i]).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                songInfo.put(genres[i], list);
            }
        }

        List<String> keySetList = new ArrayList<>(genreInfo.keySet());
        Collections.sort(keySetList, (o1, o2) -> (genreInfo.get(o2).compareTo(genreInfo.get(o1))));
        List<Integer> ansList = new ArrayList<>();

        for(String k : keySetList) {
            List<Integer> li = songInfo.get(k);
            int[][] arr = new int[li.size()][2];

            for(int i = 0; i<li.size(); i++) {
                arr[i][0] = li.get(i);
                arr[i][1] = plays[arr[i][0]];
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
                    return Integer.compare(o2[1], o1[1]);
                }
            });
            ansList.add(arr[0][0]);
            if(arr.length>=2)
                ansList.add(arr[1][0]);
        }

        answer = new int[ansList.size()];
        int size = 0;
        for(int a : ansList)
            answer[size++] = a;

        return answer;
    }
}
