import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int switch_cnt = sc.nextInt(); //스위치 개수
        arr = new int[switch_cnt+1]; //스위치의 상태(0:꺼짐, 1:켜짐)
        for(int i = 1; i<=switch_cnt; i++) {
            arr[i] = sc.nextInt();
        }
        int student = sc.nextInt(); //학생수

        for(int i = 0; i<student; i++) {
            int sex = sc.nextInt(); //1:남학생, 2:여학생
            int number = sc.nextInt(); //학생이 받은 수

            if(sex == 1) { //남학생이면 number의 배수들을 뒤집는다.
                for(int a = 0; a<arr.length; a++) {
                    if(a % number == 0) {
                        change(a);
                    }
                    else
                        continue;
                }
            }

            else { //여학생이면 number를 기준으로 좌우대칭인 구간을 뒤집음
                change(number);
                int num1 = number - 1;
                int num2 = number + 1;
                while(true) {
                    if(num1 < 1 || num2 > arr.length-1)
                        break;

                    if(arr[num1] != arr[num2])
                        break;

                    change(num1);
                    change(num2);
                    num1--;
                    num2++;
                }
            }
        }

        for(int i = 1 ; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
            if(i % 20 == 0)
                System.out.println();
        }
    }

    static void change(int num) {
        if(arr[num] == 0)
            arr[num] = 1;
        else
            arr[num] = 0;
    }
}
