//���� �˰��� 1543 : ���� �˻�

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine(); //����
        String[] s = st.split("");
        String ans = br.readLine(); //�˻��ϰ� ���� �ܾ� 
        int count = 0; //Ƚ��
        
        for(int i = 0; i<=s.length-ans.length(); i++) {
        	String a = "";
        	
        	for(int j = i; j<i+ans.length(); j++) {
        		a += s[j];
        	}
        	
        	if(ans.equals(a)) {
        		count++;
        		i = i +ans.length() -1; //�ߺ��Ǹ� �ȵǱ� ����
        	}
        }
        System.out.println(count);
    }
}