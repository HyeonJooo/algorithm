import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] check = new boolean[n];
        int count = 0;
        int num = 0; //시작은 0번부터

        while(true) {
            if(num == k){
                System.out.println(count);
                System.exit(0);
            }

            if(check[num] == true){
                System.out.println(-1);
                System.exit(0);
            }

            check[num] = true;
            num = arr[num];
            count++;
        }
    }
}
