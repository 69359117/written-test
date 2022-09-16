package lianxiang_0727.src.main.java.zj_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-04 18:59
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//高
        int M = sc.nextInt();//每行宽
        int[][] score = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                score[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {//第一行出发点
            int res = 0;
            if(score[0][i] > 0) res += score[0][i];


        }

    }
}
