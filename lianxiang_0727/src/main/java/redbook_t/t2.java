package lianxiang_0727.src.main.java.redbook_t;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-19 15:45
 */
/*
5 2
1 5 3 4 2
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();
        int[] dp = new int[n];      // 抵达i山的最小花费
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] mountains = new int[n];
        for (int i = 0; i < n; i++) {
            mountains[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i + j < n) {
                    int cost = Math.max(mountains[i + j] - mountains[i], 0);
                    dp[i + j] = Math.min(dp[i + j], dp[i] + cost);
                }
            }
        }

        System.out.println(dp[n - 1]);
    }
}
