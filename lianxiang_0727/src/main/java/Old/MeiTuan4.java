package Old;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;



//3 5 1
//2 1 2 3 2
//9 6 2 1 7
//1 3 0 5 2
public class MeiTuan4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int now = sc.nextInt();
        int[] taskCity=new int[m];
        long[] pointNot=new long[m];
        long[] pointMove=new long[m];
        for (int i = 0; i < m; i++) {
            taskCity[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            pointNot[i]=sc.nextLong();
        }
        for (int i = 0; i < m; i++) {
            pointMove[i]=sc.nextLong();
        }
        long[][] dp=new long[m][4];
        // change
        dp[0][0]=taskCity[0];
        dp[0][1]=(now==taskCity[0]?pointNot[0]:pointMove[0]);
        // stay
        dp[0][2]=now;
        dp[0][3]=(now==taskCity[0]?pointNot[0]:0);
        for (int i = 1; i < m; i++) {
            long a,b;
            if (taskCity[i]==dp[i-1][0]){
                a=dp[i-1][1]+pointNot[i];
            }else {
                a=dp[i-1][1]+pointMove[i];
            }

            if (taskCity[i]==dp[i-1][2]){
                b=dp[i-1][3]+pointNot[i];
            }else {
                b=dp[i-1][3]+pointMove[i];
            }
            dp[i][1]=Math.max(a,b);
            dp[i][0]=taskCity[i];

            if (dp[i-1][1]>dp[i-1][3]){
                dp[i][2]=dp[i-1][0];
            }else {
                dp[i][2]=dp[i-1][2];
            }
            dp[i][3]=Math.max(dp[i-1][1],dp[i-1][3]);
        }
        long max = Math.max(dp[m - 1][1], dp[m - 1][3]);
        System.out.println(max);
    }

}

