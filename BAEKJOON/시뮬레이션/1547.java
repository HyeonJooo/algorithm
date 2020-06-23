import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int ans = 1;
        for(int i = 0 ; i<m; i++) {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	
        	if(x==ans)
        		ans = y;
        	else if(y==ans)
        		ans = x;
        	else if(x==ans && y==ans)
        		ans = x;
        	else
        		continue;
        }
        System.out.println(ans);
    }
}
