package tjhmeituan;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/*
3 5 1
2 1 2 3 2
9 6 2 1 7
1 3 0 5 2
 */
public class t4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//总城市
        int m = sc.nextInt(), k = sc.nextInt();//总天数m和初始所在城市k

        int[] arr = new int[m];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
            sum1 += arr[i];
        }
        int[] brr = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
            sum2 += brr[i];
        }
        int[][] dp = new int[m][n];//第i天在第j个城市赚的最多钱
        System.out.println(sum1);
//        System.out.println(sum2);
    }
}
