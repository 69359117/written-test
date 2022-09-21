package lianxiang_0727.src.main.java.xiaomi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-20 19:08
 */
/*
1 3
2 6
8 10
15 18
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> ans = new ArrayList<>();
        while(sc.hasNext()){
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            ans.add(temp);
        }

        int[][] interval = ans.toArray(new int[ans.size()][2]);
        Arrays.sort(interval, (o1, o2) -> o1[0] - o2[0]);//左边界排序

        int start = interval[0][0];
        int end = interval[0][1];
        int count = 0;
        for (int i = 1; i < interval.length ; i++) {
            if(end >= interval[i][0]){
                end = Math.max(end, interval[i][1]);
            }else{
//                list.add(new int[]{start, end});
                start = interval[i][0];
                end = interval[i][1];
                count += (end - start);
            }
            if(i == interval.length - 1){
//                list.add(new int[]{start, end});
                count += (end - start);
            }
        }
    }
}
