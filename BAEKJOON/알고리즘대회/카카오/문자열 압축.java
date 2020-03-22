//2020 카카오 신입공채 1차 코딩테스트
class Solution {
    public int solution(String s) {
        String[] arr;
        arr = s.split("");
        int answer = Integer.MAX_VALUE;
        if(arr.length == 1)
            answer = 1;
        else{
            int min = 0, num = 1, cnt = 1, idx = 1;
            String ans = "";
            String word = arr[0];
            String tmp = arr[1];
            while(num <= s.length()/2) {
                if(tmp.equals(word)) {
                    cnt++;
                    idx += num;
                    tmp = "";
                    for(int i = idx; i<idx+num; i++) {
                        if(i >= arr.length)
                            break;
                        tmp += arr[i];
                    }        	
                }

                else {      	
                    if(cnt != 1) 
                        ans += Integer.toString(cnt);
                    ans += word;
                    word = "";
                    tmp = "";
                    for(int i = idx; i<idx+num; i++) {
                        if(i >= arr.length)
                            break;
                        word += arr[i];
                    }
                    for(int i = idx+num; i<idx+num+num; i++) {
                        if(i >= arr.length)
                            break;
                        tmp += arr[i];
                    }
                    idx += num;
                    cnt = 1;
                }

                if(idx>= arr.length) {
                    if(cnt!=1)
                        ans += Integer.toString(cnt);
                    ans += word;
                    min = ans.length();
                    if(answer > min)
                        answer = min;
                    ans = "";
                    word = "";
                    tmp = "";
                    cnt = 1;
                    num++;
                    for(int i = 0; i<num; i++) {
                        word += arr[i];
                    }
                    for(int i = num; i<num+num; i++) {
                        if(i>=arr.length)
                            break;
                        tmp += arr[i];
                    }
                    idx = num;
                }
            }            
        }
        return answer;
    }
}
