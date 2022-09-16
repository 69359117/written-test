package lianxiang_0727.src.main.java.huawei_t;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-14 18:55
 */
/*
2 2 1
2

1 3 2
1 3
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();//生命值
        int N = sc.nextInt();//木板个数（吊桥长度）
        int K = sc.nextInt();//缺失的目标个数
//        int[] last = new int[K];
//        for (int i = 0; i < K; i++) last[i] = sc.nextInt();
        boolean[] bridge = new boolean[N+2];
        Arrays.fill(bridge, true);
        for (int i = 0; i < K; i++) bridge[sc.nextInt()] = false;

        //相当于从0走到N+1
        int[][] dp = new int[N+2][M+1];//走到第i个木板，生命值为j的次数是dp[i][j]
        for (int i = 0; i < M + 1; i++) dp[0][i] = 1;//初始化 dp[0][j]=1

        int j = M;//生命值
        for (int i = 1; i < N + 2; i++) {//第几个木板
//            for (int j = 1; j < M + 1; j++) {//j是生命值

                if(!bridge[i-1]){//i-1缺失
                    if(j < M) dp[i][j] = dp[i-1][j+1];
                    else{
                        dp[i][j] = dp[i-1][j+1];
                        j--;
                    }
                }else {
                    dp[i][j] = dp[i-1][j];
                }

                if(i>=2 && !bridge[i-2]){//i-2缺失
                    if(j < M) dp[i][j] += dp[i-2][j+1];
                    else{
                        dp[i][j] += dp[i-2][j+1];
                        j--;
                    }
                }else if(i >= 2){
                    dp[i][j] += dp[i-2][j];
                }

                if(i>=3 && !bridge[i-3]){//i-3缺失
                    if(j < M) dp[i][j] += dp[i-3][j+1];
                    else{
                        dp[i][j] += dp[i-3][j+1];
                        j--;
                    }
                }else if(i >= 3){
                    dp[i][j] += dp[i-3][j];
                }

//            }
        }
        int res = 0;
        for (int i = 1; i < M + 1; i++) {//生命值从1~M
            res += dp[N+1][i];
        }
        System.out.println(res);


    }
}
