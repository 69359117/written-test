package lianxiang_0727.src.main.java.xiaomi;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-20 19:32
 */


public class t2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine(), sc.nextLine()));
    }

    public static int solution(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return len1 + len2;
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;//初始化
        for (int i = 0; i <= len2; i++) dp[0][i] = i;
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int lastOne = dp[i - 1][j - 1];
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) lastOne++;

                int current = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                current = Math.min(current, lastOne);
                dp[i][j] = current;
            }
        }
        return dp[len1][len2];

    }
}