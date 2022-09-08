package lianxiang_0727.src.main.java.zj_t;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-04 19:49
 */
/*
3 3
-1 0 -1
100 0 0
0 50 70

4 3
-1 0 -1
0 -1 0
50 100 70
80 200 50
 */
public class t1_sg {
    static int N;
    static int M;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//高
        M = sc.nextInt();//每行宽
        int[][] score = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                score[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {//第一行出发点
            ans = Math.max(ans, solution(score, 0, i));
        }
        System.out.println(ans);
    }

    public static int solution(int[][] score, int n, int m){//n为行数 m为列数
        if(n >= N) return 0;
        if(m < 0 || m >= M) return 0;
        int point = n * M + m;
        if( map.containsKey(point) ) return map.get(point);

        int ans = 0;
        if(score[n][m] == -1){
            ans += Math.max(solution(score, n + 1, m + 1), solution(score, n + 1, m - 1));
        }else{
            ans += solution(score, n + 1, m) + score[n][m];
        }
        map.put(point, ans);
        return ans;
    }
}
