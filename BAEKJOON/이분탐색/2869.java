//백준 알고리즘 2869번 : 달팽이는 올라가고 싶다
import java.util.*;
import java.io.*;
public class Main{
   public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int day = 0;

      day = 1 + ((v-a)%(a-b) == 0 ? (v-a)/(a-b):(v-a)/(a-b)+1);
      System.out.println(day);
   }
}
