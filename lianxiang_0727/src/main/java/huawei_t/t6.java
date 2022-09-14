package huawei_t;

import java.util.Arrays;
import java.util.Scanner;

//3 4 3

public class t6 {


    static int[][][] find ;
    static boolean[][][] visited ;
//    static int T, n, m, k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        find = new int[n+1][m+1][k+1];
        for (int i = 0; i < find.length; i++) {
            for (int j = 0; j < find[0].length; j++) {
                for (int l = 0; l < find[0][0].length; l++) {
                    find[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        visited = new boolean[n+1][m+1][k+1];
        System.out.println(dfs(n, m, k));
    }

    public static int dfs(int n, int m, int k) {
        if (n > m) return dfs(m, n, k);
        if (visited[n][m][k]) return find[n][m][k];     // n*m 划分 k 块需要的
        visited[n][m][k] = true;
//        if (k == 0 || n * m == k) return find[n][m][k] = 0;
        if (k==1) {
            find[n][m][k] = 0;
            return 0;
        }
        if(k==2){
            int min = Math.min(m,n);
            find[n][m][k] = min*min;
            return min*min;
        }


        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= Math.min(i * m, k); j++) {
                find[n][m][k] = Math.min(find[n][m][k], dfs(i, m, j) + dfs(n - i, m, k - j) + m * m);
            }
        }
        for (int i = 1; i <= m / 2; i++) {
            for (int j = 1; j <= Math.min(i * n, k); j++) {
                find[n][m][k] = Math.min(find[n][m][k], dfs(n, i, j) + dfs(n, m - i, k - j) + n * n);
            }
        }
        return find[n][m][k];
    }

}
