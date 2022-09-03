package lianxiang_0727.src.main.java;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

//    public class Main{


public class MeiTuan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][2];
        boolean[][] isHas = new boolean[n][26];
        for (int i = 1; i < n; i++) {
            int num = sc.nextInt() - 1;
            dp[i][0] = num;
            dp[num][1]++;
        }
        String next = sc.next();
        for (int i = 0; i < n; i++) {
            isHas[i][next.charAt(i) - 'A'] = true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (dp[i][1] == 0) queue.add(i);
        }
        //
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int num = dp[poll][0];
            dp[num][1]--;
            add(isHas[num], isHas[poll]);
            if (num != 0 && dp[num][1] == 0) queue.add(num);
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < 26; j++) {
                if (isHas[i][j]) count++;
            }
            System.out.print(count + " ");
        }
    }

    private static void add(boolean[] arr1, boolean[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr2[i]) arr1[i] = true;
        }
    }
}
