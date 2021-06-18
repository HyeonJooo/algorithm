import java.io.*;
import java.util.*;

class Top {
    int height;
    int idx;

    public Top(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i<=n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Top(height, i));
            }

            else {
                while (true) {
                    if(stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Top(height, i));
                        break;
                    }

                    Top top = stack.peek();

                    //peek번호 출력, 새로 push
                    if(top.height > height) {
                        sb.append(top.idx + " ");
                        stack.push(new Top(height, i));
                        break;
                    }

                    //peek-> pop하고 다시 반복
                    else {
                        stack.pop();
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
