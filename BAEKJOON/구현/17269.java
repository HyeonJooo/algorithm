import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n,m:이름의 길이
        int n = sc.nextInt();
        int m = sc.nextInt();

        //A,B:이름
        String A = sc.next();
        String B = sc.next();

        String new_name = "";
        String[] nameA;
        String[] nameB;
        nameA = A.split("");
        nameB = B.split("");

        if(n < m) {
            for(int i = 0 ; i<n; i++) {
                new_name += nameA[i];
                new_name += nameB[i];
            }

            for(int i = n; i<m; i++) {
                new_name += nameB[i];
            }
        }

        else {
            for(int i = 0 ; i<m; i++) {
                new_name += nameA[i];
                new_name += nameB[i];
            }

            for(int i = m; i<n; i++) {
                new_name += nameA[i];
            }
        }

        String[] st;
        st = new_name.split("");

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i = 0; i<st.length; i++) {
            if(st[i].equals("C") || st[i].equals("G") || st[i].equals("I") || st[i].equals("J") || st[i].equals("L") ||
                    st[i].equals("O") || st[i].equals("S") || st[i].equals("U") || st[i].equals("V") || st[i].equals("W")|| st[i].equals("Z")) {
                list1.add(1);
            }
            else if(st[i].equals("B") || st[i].equals("D") || st[i].equals("N") || st[i].equals("P") || st[i].equals("Q") ||
                    st[i].equals("R") || st[i].equals("T") || st[i].equals("X") || st[i].equals("Y")) {
                list1.add(2);
            }
            else if(st[i].equals("A") || st[i].equals("F") || st[i].equals("H") || st[i].equals("K") || st[i].equals("M")) {
                list1.add(3);
            }
            else
                list1.add(4);
        }

        while(true) {
            if(list1.size() == 2)
                break;

            for(int i = 0; i<list1.size()-1; i++) {
                int num = list1.get(i) + list1.get(i+1);
                if(num >= 10)
                    num %= 10;
                list2.add(num);
            }
            list1.clear();
            list1 = new ArrayList<>(list2);
            list2.clear();
        }

        String answer = "";
        if(list1.get(0) != 0)
            answer += list1.get(0).toString();
        answer += list1.get(1).toString();
        answer += "%";
        System.out.print(answer);
    }
}
