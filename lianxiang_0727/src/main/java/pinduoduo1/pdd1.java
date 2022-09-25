package pinduoduo1;

import java.util.*;
import java.util.concurrent.locks.Condition;

/*

3 3 2
4 1 1 1 1
4 2 2 2 2
5 2 2 2 3 4

 */


public class pdd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       // 山数量
        int P = sc.nextInt();       // 一次高度
        int K = sc.nextInt();       // 一次台阶数
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();     // 台阶数
            int[] ints = new int[n];
            for (int j = 0; j < n; j++) {
                ints[j] = sc.nextInt();
            }
            list.add(ints);
        }
        Solution(list, P, K);
    }


    public static void Solution(ArrayList<int[]> list, int P, int K) {
        int mod = 1000000007;
        for (int[] ints : list) {
            int max = Integer.MIN_VALUE;
            for (int i : ints) {
                max = Math.max(max,i);
            }
            if(max > K){
                System.out.println(0);
                continue;
            }
            int[] dp = new int[ints.length+1];
            dp[0] = 1;
            for (int i = 1; i <= ints.length; i++) { // 走到 i 级台阶的种类数
                int tem_sum = 0;            // 累积的 高度
                int tem_nums = 0;           // 累积的 台阶数
                int index = i-1;            // 考虑的台阶序号
                while (index >= 0){
                    tem_sum += ints[index];
                    tem_nums++;
                    if(tem_sum <= P && tem_nums <= K){
                        dp[i] += dp[index];
                        dp[i] = dp[i]%mod;
                        index --;
                    }else {
                        break;
                    }
                }
            }
            System.out.println(dp[ints.length]);

        }


    }

}

