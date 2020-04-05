//백준 알고리즘 2292번 : 벌집
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        
        int i = 0, count = 1;
        int result = 0;
        int a;
        if(n == 1) {
        	count = 1;
        }
        else {
        	while(true) {
        		if(n>=2+(6*result) && n<=2+(6*result)+(6*(i+1)-1)) {
        			count++;
        			break;
        		}
        		else {
        			i++;
        			count++;
        			result += i;
        		}
        	}
        }
        System.out.println(count);
    }
}
