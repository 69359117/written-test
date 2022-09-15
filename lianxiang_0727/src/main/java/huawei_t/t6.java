package huawei_t;

import java.util.Arrays;
import java.util.Scanner;

//3 4 3

public class t6 {


    static long[][][] find ;
    static boolean[][][] used ;
//    static int T, n, m, k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        find = new long[n+1][m+1][k+1];
        for (int i = 0; i < find.length; i++) {
            for (int j = 0; j < find[0].length; j++) {
                for (int l = 0; l < find[0][0].length; l++) {
                    find[i][j][k] = Long.MAX_VALUE;
                }
            }
        }
        used = new boolean[n+1][m+1][k+1];
        System.out.println(dfs(n, m, k));
    }

    public static long dfs(int n, int m, int k) {
        if (n > m) return dfs(m, n, k);
        if (used[n][m][k]) return find[n][m][k];     // n*m 划分 k 块需要的
        if (k<=1) {
            find[n][m][k] = 0;
            return 0;
        }
        if(k==2){
            long min = Math.min(m,n);
            find[n][m][k] = min*min;
            return min*min;
        }


        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= Math.min(i * m, k-1); j++) {
//                find[n][m][k] = Math.min(find[n][m][k], dfs(i, m, j) + dfs(n - i, m, k - j) + m * m);
                find[n][m][k] = Math.min(find[n][m][k], dfs(m,i, j) + dfs(m, n - i, k - j) + m * m);
            }
        }
        for (int i = 1; i <= m / 2; i++) {
            for (int j = 1; j <= Math.min(i * n, k-1); j++) {
//                find[n][m][k] = Math.min(find[n][m][k], dfs(n, i, j) + dfs(n, m - i, k - j) + n * n);
                find[n][m][k] = Math.min(find[n][m][k], dfs(i,n,  j) + dfs(m - i, n, k - j) + n * n);
            }
        }
        used[n][m][k] = true;

        return find[n][m][k];
    }

}
