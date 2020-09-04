import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	int i = 1;
    	while(true) {
    		int L = sc.nextInt();
        	int P = sc.nextInt();
        	int V = sc.nextInt();
        	int answer = 0;
        	if(L==0 && P==0 && V==0)
        		break;
        	
        	answer = V/P*L;
        	if(V%P < L)
        		answer += V%P;
        	else
        		answer += L;
        	System.out.println("Case " + i + ": " + answer);
        	i++;
    	}
    }
}
