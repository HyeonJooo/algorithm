//shake! 2019
//백준 알고리즘 17479번 : 정식당
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int c = sc.nextInt();
    	HashMap<String, Integer> ahm = new HashMap<>();//일반메뉴 저장
    	HashMap<String, Integer> bhm = new HashMap<>();//특별메뉴 저장    	
    	String[] special = new String[c];//스페셜
    	for(int i =0; i<a; i++) {
    		String s = sc.next();
    		int num = sc.nextInt();
    		ahm.put(s, num);
    	}
    	for(int i =0; i<b; i++) {
    		String s = sc.next();
    		int num = sc.nextInt();
    		bhm.put(s, num);
    	}
    	for(int i = 0 ; i<c; i++) {
    		special[i] = sc.next();
    	}
    	
    	long aprice = 0, bprice = 0;
    	int check = 0;
    	int n = sc.nextInt();
    	
    	for(int i = 0 ; i<n; i++) {
    		String s = sc.next();
    		if(ahm.containsKey(s)) //일반메뉴이면
    			aprice += ahm.get(s);//일반메뉴 가격 플러스
    		else if(bhm.containsKey(s))//특별메뉴이면
    			bprice += bhm.get(s);//특별메뉴 가격 플러스
    		else
    			check++;
    	}
    	if(aprice < 20000 && bprice != 0)//일반메뉴 2만원 안되는데 특별메뉴 시킨경우
    		System.out.println("No");
    	else if(aprice+bprice <50000 && check != 0)//일반+특별 5만원 안되는데 스페셜 시킨경우
    		System.out.println("No");
    	else if(check>1)//스페셜 2개이상 시킨경우
    		System.out.println("No");
    	else
    		System.out.println("Okay");
    }
}
