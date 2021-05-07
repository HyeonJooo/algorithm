import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long k = 10;
        long[] arr = {1,3,4,1,3,1};
        long[] ans = solution(k,arr);
        for(int i = 0;i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    static HashMap<Long, Long> room = new HashMap<>();
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i = 0; i< room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    public static long findRoom(long num) {
        if(!room.containsKey(num)) {
            room.put(num, num+1);
            return num;
        }
        long save = findRoom(room.get(num));
        room.put(num, save);
        return save;
    }
}
