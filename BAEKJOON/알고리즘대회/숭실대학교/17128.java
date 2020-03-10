//숭실대학교 2019 SCCC 벚꽃맞이 컨테스트
//백준 알고리즘 17128번 : 소가 정보섬에 올라온 이유
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());//소의 수
    	int q = Integer.parseInt(st.nextToken());//장난칠 횟수
    	int[] arr = new int[n];
		int sum = 0;
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		arr[i] = Integer.parseInt(str.nextToken()); //소의 품질
    	}
    	
    	for(int i = 0; i<n; i++) {
    		sum += (arr[i%n] * arr[(i+1)%n] * arr[(i+2)%n] * arr[(i+3)%n]);
    	}
    	
    	StringTokenizer stq = new StringTokenizer(br.readLine());
    	for(int i = 0; i<q; i++) {
    		int num = Integer.parseInt(stq.nextToken()); //장난칠 소의 번호
    		arr[num-1] *= -1; //장난칠 소의 품질 부호를 바꿈
    		int tmp = 0;
    		int cnt = 0;
			int j = num-1;
    		while(cnt != 4) {
    			if(j < 0)
    				j += n;
    			tmp += (arr[j%n] * arr[(j+1)%n] * arr[(j+2)%n] * arr[(j+3)%n]);
    			j--;
    			cnt++;
    		}
    		sum = sum + (2*tmp);
    		bw.write(sum + "\n");
    	}
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
