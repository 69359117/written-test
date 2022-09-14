package lianxiang_0727.src.main.java.huawei_t;

/**
 * @author Tdd
 * @creat 2022-09-14 21:57
 */
public class t5 {
    static int[][][] find = new int[31][31][51];
    static boolean[][][] visited = new boolean[31][31][51];
    static int T, n, m, k;
    
    public static int dfs(int n, int m, int k) {
        if (n > m) return dfs(m, n, k);
        if (visited[n][m][k]) return find[n][m][k];
        visited[n][m][k] = true;
        if (k == 0 || n * m == k) return find[n][m][k] = 0;
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 0; j <= Math.min(i * m, k); j++) {
                find[n][m][k] = Math.min(find[n][m][k], dfs(i, m, j) + dfs(n - i, m, k - j) + m * m);
            }
        }
        for (int i = 1; i <= m / 2; i++) {
            for (int j = 0; j <= Math.min(i * n, k); j++) {
                find[n][m][k] = Math.min(find[n][m][k], dfs(n, i, j) + dfs(n, m - i, k - j) + n * n);
            }
        }
        return find[n][m][k];
    }
}


