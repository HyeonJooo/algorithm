//백준 알고리즘 1021번 : 회전하는 큐
import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        list = new ArrayList<>();
        for(int i =1; i<=n; i++) {
        	list.add(i);
        }
        
        int[] arr = new int[m];
        for(int i = 0 ; i<m; i++) {
        	arr[i] = sc.nextInt();
        }
        
        int cnt = 0;
        
        for(int i = 0 ; i<m; i++) {
       		while(true) {
       			if(list.get(0) == arr[i]) {//1번연산
           			left();
           			list.remove(list.size()-1);
           			break;        			
            	}
           		else {
           			int num1 = list.indexOf(arr[i]);
           			int num2 = list.size() - list.lastIndexOf(arr[i]);
           			if(num1 <= num2) {
           				while(true) {
               				left();
               				cnt++;
               				if(list.get(0) == arr[i])
               					break;
           				}
           			}

            		else {
            			while(true) {
                			right(); 
                			cnt++;
                			if(list.get(0) == arr[i])
                				break;
            			}
            		}
           		}
       		}
        }
        System.out.println(cnt);
    }
	
	public static void left() {//2번 연산. 왼쪽으로 이동
		int tmp = list.get(0);
		int size= list.size();
		for(int i = 1 ; i<size; i++) {
			int num = list.get(i);
			list.remove(i-1);
			list.add(i-1, num);
		}
		list.remove(list.size()-1);
		list.add(tmp);
	}
	
	public static void right() {//3번 연산. 오른쪽으로 이동
		int tmp = list.get(list.size()-1);
		int size = list.size();
		for(int i = size-1 ; i>0; i--) {
			int num = list.get(i-1);
			list.remove(i);
			list.add(i, num);
		}
		list.remove(0);
		list.add(0,tmp);
	}
}
