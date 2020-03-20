//2019 중앙대학교 프로그래밍 경진대회
//백준 알고리즘 17478번 : 재귀함수가 뭔가요?
import java.io.*;
import java.util.*;
public class Main {
	static int cnt = 0;
	static int n;
	static String s = "____";
	static String s1 = "\"재귀함수가 뭔가요?\"";
	static String s2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String s3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String s4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	static String s5 = "라고 답변하였지.";
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	
    	System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
    	System.out.println(s1);
    	recursive();
    	System.out.println("라고 답변하였지.");
    }
    public static void recursive() {    	
    	System.out.println(s2);
    	System.out.println(s3);
    	System.out.println(s4);
    	
   		s1 = s+s1;
   		s2 = s+s2;
   		s3 = s+s3;
   		s4 = s+s4;
    	
    	System.out.println(s1);
    	cnt++;
    	
    	if(cnt != n)
    		recursive();
    	else {
    		for(int i = 0; i<cnt; i++) {
    			System.out.print(s); 		    			
    		}
    		System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");   
    	}

    	for(int i = 0 ; i<cnt; i++) {
    		System.out.print(s);
    	}
    	System.out.println(s5);
    	cnt--;
    }
}
