import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<2*n-1; i++) {
            String name = sc.next();
            if(map.containsKey(name)) {
                map.put(name, map.get(name)+1);
            } else {
                map.put(name, 1);
            }
        }

        for(String name : map.keySet()) {
            if (map.get(name) % 2 == 1) {
                System.out.println(name);
                break;
            }
        }
    }
}
