package xiaohongshu;

import java.util.Scanner;

//horse
//ros


public class xiaomi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(solution(s1, s2));

    }


    public static int solution(String s1, String s2){

        int n1 = s1.length() , n2 = s2.length();
        if(n1==0 || n2 == 0 ){
            return n1+n2;
        }

        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i]=i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int tem = dp[i-1][j-1];
                if(s1.charAt(i-1) != s2.charAt(j-1)){
                    tem++;
                }
                int now = Math.min(dp[i-1][j],dp[i][j-1])+1;
                now = Math.min(now , tem);
                dp[i][j] = now;
            }
        }
        return dp[n1][n2];

    }
}