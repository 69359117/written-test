package lianxiang_0727.src.main.java.sf_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-07 20:04
 */
public class t0 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int number = cin.nextInt();
        if(number <= 3){
            System.out.println(1);
            return;
        }

        long[] dp = new long[number+1];
        dp[1] = dp[2] = dp[3] = 1;
        long mod = 1000000007;
        for (int i = 4; i <= number; i++) dp[i] = dp[i-1]%mod + dp[i-2]%mod + dp[i-3]%mod + 1;

        System.out.println(dp[number]%mod);
    }
}
