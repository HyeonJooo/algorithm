import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        long[][] stairArray = new long[100][9];
        long result = 0;
        
        for(int i=0; i<9; i++) {
            stairArray[0][i] = 1;
            
            if(i==8) {
                stairArray[1][i] = 1; 
            }else {
                stairArray[1][i] = 2;
            }
        }
        
        if(n>2) {
            for(int i=2; i<n; i++) { 
                for(int j=0; j<9; j++) {
                    
                    if(j==0) {
                        stairArray[i][j] = (stairArray[i-2][j] + stairArray[i-1][j+1])%1000000000;
                    }else if(j==8) {
                        stairArray[i][j] = (stairArray[i-1][j-1])%1000000000;
                    }else {
                        stairArray[i][j] = (stairArray[i-1][j-1] + stairArray[i-1][j+1])%1000000000;
                    }
                }
            }
        }
        
        for(int i=0; i<9; i++) {
            result += stairArray[n-1][i];
        }
        bw.write(String.valueOf(result%1000000000));
        bw.flush();
        
    }
 
}
 
