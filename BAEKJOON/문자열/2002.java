import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> start = new HashMap<>();
        int[] arr = new int[n];

        for(int i = 0; i<n; i++) {
            String car = sc.next();
            start.put(car, i);
        }

        for(int i = 0 ; i<n; i++) {
            String car = sc.next();
            arr[i] = start.get(car);
        }

        int answer = 0;
        for(int i = 0 ; i<n-1; i++) {
            for(int j = i+1; j<n; j++) {
                if(arr[i] > arr[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
