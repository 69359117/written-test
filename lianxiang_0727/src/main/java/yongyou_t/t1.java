package lianxiang_0727.src.main.java.yongyou_t;

/**
 * @author Tdd
 * @creat 2022-09-09 19:04
 */
public class t1 {
    public static void main(String[] args) {
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(5));
    }

    public static int solution(int n){
        if(n <= 2) return 1;
        int[] dp = new int[n+1];
        for (int i = 0; i <= 2; i++) dp[i] = 1;//第i个月的兔子数量
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];

    }
}
