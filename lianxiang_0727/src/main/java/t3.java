import java.util.ArrayList;
import java.util.Scanner;


// ababa

public class t3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solution(s);
    }


    public static void solution(String s) {
        long res = 0;
        // false 表示该字母为偶数
        int flags = 0;
        int[] pres = new int[s.length() + 1];
        pres[0] = flags;
        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(i) - 'a';
            flags = flags ^ ( 1 << (now) );
            pres[i + 1] = flags;
            for (int j = 0; j <= i; j++) {
                int tem = pres[j] ^ flags;
                if (tem != 0 && (tem & (tem - 1)) == 0) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
