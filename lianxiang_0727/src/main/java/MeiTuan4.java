package lianxiang_0727.src.main.java;

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
        int city = sc.nextInt();
        int[] pos=new int[m];
        int[] A=new int[m];
        int[] B=new int[m];
        for (int i = 0; i < m; i++) {
            pos[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            A[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i]=sc.nextInt();
        }
        int[][] dp=new int[m][4];
        // change
        dp[0][0]=pos[0];
        dp[0][1]=(city==pos[0]?A[0]:B[0]);
        // stay
        dp[0][2]=city;
        dp[0][3]=(city==pos[0]?A[0]:0);
        for (int i = 1; i < m; i++) {
            int a,b;
            if (pos[i]==dp[i-1][0]){
                a=dp[i-1][1]+A[i];
            }else {
                a=dp[i-1][1]+B[i];
            }

            if (pos[i]==dp[i-1][2]){
                b=dp[i-1][3]+A[i];
            }else {
                b=dp[i-1][3]+B[i];
            }
            dp[i][1]=Math.max(a,b);
            dp[i][0]=pos[i];

            if (dp[i-1][1]>dp[i-1][3]){
                dp[i][2]=dp[i-1][0];
            }else {
                dp[i][2]=dp[i-1][2];
            }
            dp[i][3]=Math.max(dp[i-1][1],dp[i-1][3])+B[i];
        }
        System.out.println(Math.max(dp[m-1][1],dp[m-1][3]));
    }

}

