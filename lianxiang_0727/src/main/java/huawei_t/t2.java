package lianxiang_0727.src.main.java.huawei_t;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Tdd
 * @creat 2022-09-14 19:45
 */
/*
5 2
5 3
1 4 5 2 3
1 6 10 3 4

3 2
6 13
2 11 5
3 25 14
 */
import java.util.*;

public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int max = 0;
        int[] hold = new int[n];
        for (int i = 0; i < n; i++) hold[i] = sc.nextInt();
        
        int[][] nums = new int[m][2];
        for (int i = 0; i < m; i++) nums[i][0] = sc.nextInt();
        for (int i = 0; i < m; i++) nums[i][1] = sc.nextInt();
        
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] < o2[0]) return 1;
            else if (o1[0] > o2[0]) return -1;
            else return o2[1] - o1[1];
        });
        
        int[] ownTime = new int[n];
        for (int i = 0; i < m; i++) {
            int indexOne = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (nums[i][0] > hold[j]) continue;
                if (ownTime[j] < min) {
                    min = ownTime[j];
                    indexOne = j;
                } else if (ownTime[j] == min) {
                    if (hold[j] < hold[indexOne]) {
                        indexOne = j;
                    }
                }
            }
            ownTime[indexOne] += nums[i][1];
        }

        for (int i = 0; i < n; i++) if (ownTime[i] > max) max = ownTime[i];
        System.out.println(max);
    }
}
