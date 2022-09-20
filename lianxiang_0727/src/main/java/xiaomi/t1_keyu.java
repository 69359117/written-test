package lianxiang_0727.src.main.java.xiaomi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-20 19:38
 */
public class t1_keyu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> ans = new ArrayList<>();
        while (sc.hasNext()) {
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            ans.add(temp);
        }

        int[][] interval = ans.toArray(new int[ans.size()][2]);
        Arrays.sort(interval, (o1, o2) -> o1[0] - o2[0]);//左边界排序

        int count = 0;
        int[][] nowTime = new int[ans.size()][2];
        int index = -1;
        for (int[] ints : interval) {
            if (index == -1 || ints[0] > nowTime[index][1])  nowTime[++index] = ints;
            else nowTime[index][1] = Math.max(nowTime[index][1], ints[1]);
        }

        int[][] copyOne = Arrays.copyOf(nowTime, index + 1);
        for (int i = 0; i < copyOne.length; i++) count += copyOne[i][1] - copyOne[i][0];

        System.out.println(count);
    }
}
