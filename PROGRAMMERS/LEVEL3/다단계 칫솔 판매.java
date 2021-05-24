import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};
        int[] ans = solution(enroll,referral,seller,amount);
        for(int i = 0; i<ans.length; i++)
            System.out.println(ans[i]);
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int[] total = new int[enroll.length+1];
        String[] parent = new String[enroll.length+1];
        Map<String, Integer> map = new HashMap<>();
        map.put("center", 0);

        for (int i = 0; i< enroll.length; i++) {
            map.put(enroll[i], i+1);
        }

        for(int i = 0; i< enroll.length; i++) {
            if(!referral[i].equals("-")) {
                parent[i+1] = referral[i];
            } else {
                parent[i+1] = "center";
            }
        }

        for(int i = 0; i< seller.length; i++) {
            int sellerIdx = map.get(seller[i]);
            int price = amount[i] * 100;

            while(true) {
                if(price < 10) {
                    total[sellerIdx] += price;
                    break;
                }
                if(sellerIdx != 0)
                    total[sellerIdx] += price - (price/10);
                else
                    total[sellerIdx] += price;
                price /= 10;
                if(sellerIdx == 0)
                    break;
                sellerIdx = map.get(parent[sellerIdx]);
            }
        }
        answer = Arrays.copyOfRange(total, 1, total.length);
        return answer;
    }
}
