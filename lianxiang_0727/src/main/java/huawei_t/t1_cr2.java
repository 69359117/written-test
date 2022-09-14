package lianxiang_0727.src.main.java.huawei_t;

import java.util.*;

/**
 * @author Tdd
 * @creat 2022-09-14 20:52
 */


public class Main {
    static long dp[][]=new long[40][6];
    static int a[]=new int[50];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        for(int i=0;i<k;i++){
            a[i]=scanner.nextInt();
        }
        Arrays.sort(a,0,k);
        int now=0;
        dp[0][0]=1;
        m--;
        for(int i=1;i<=n+1;i++){
            if(now<k&&a[now]==i){
                if(i-1>=0){
                    for(int j=m;j>0;j--){
                        dp[i][j]+=dp[i-1][j-1];
                    }
                }
                if(i-2>=0){
                    for(int j=m;j>0;j--){
                        dp[i][j]+=dp[i-2][j-1];
                    }
                }
                if(i-3>=0){
                    for(int j=m;j>0;j--){
                        dp[i][j]+=dp[i-3][j-1];
                    }
                }
                now++;
            }else{
                if(i-1>=0){
                    for(int j=m;j>=0;j--){
                        dp[i][j]+=dp[i-1][j];
                    }
                }
                if(i-2>=0){
                    for(int j=m;j>=0;j--){
                        dp[i][j]+=dp[i-2][j];
                    }
                }
                if(i-3>=0){
                    for(int j=m;j>=0;j--){
                        dp[i][j]+=dp[i-3][j];
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<=m;i++){
            ans+=dp[n+1][i];
        }
        System.out.println(ans);
    }
}
/*
2 2 1
2
1 3 2
1 3

15
901 925 920 895 853
805 894 805 858 845
826 859 775 784 838
4
* */