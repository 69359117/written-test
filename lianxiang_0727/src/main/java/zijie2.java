import java.util.Arrays;
import java.util.Scanner;


//0101011101

// 00000

// 11101

// 01011010

public class zijie2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution(s);

    }


    public static void Solution(String s) {
        String[] ss = s.split("");
        if (s.length() < 3) {
            System.out.println(0);
        }
        int l = 0, r = 1;
        int ans = 0;
        while (r < s.length()) {
            if (!ss[r].equals(ss[r - 1])) {
                r++;
            } else {
                if (r - l >= 3) {
                    ans = Math.max(ans, r - l);
                }
                l = r;
                r++;
            }
        }
        if (r - l >= 3) {
            ans = Math.max(ans, r - l);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('a');
        sb.toString();

        System.out.println(ans);
    }
}
