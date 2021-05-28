import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int b = 100;
        int w = 100;
        int[] t = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(b,w,t));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        int curWeight = 0;

        for(int i = 0; i<truck_weights.length; i++){
            while(true){
                if(queue.isEmpty()){
                    queue.offer(truck_weights[i]);
                    curWeight += truck_weights[i];
                    answer++;
                    break;
                }
                else if(queue.size() == bridge_length){
                    curWeight -= queue.poll();
                }
                else{
                    if(curWeight + truck_weights[i] > weight){
                        queue.offer(0);
                        answer++;
                    }
                    else{
                        queue.offer(truck_weights[i]);
                        curWeight += truck_weights[i];
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }

}
