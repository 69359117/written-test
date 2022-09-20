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
        while(true){
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            ans.add(temp);
            if(!sc.hasNext()) break;
        }
        int[][] interval = ans.toArray(new int[ans.size()][2]);
        for(int[] temp : ans){
            for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i]+" ");
            }
            System.out.println();
        }
//        Arrays.sort();

        int start = interval[0][0];
        int end = interval[0][1];
        int count = 0;
        for (int i = 1; i < interval.length; i++) {
            if(end >= interval[i][0]){
                end = Math.max(end, interval[i][1]);
            }else{
//                list.add(new int[]{start, end});
//                start = interval[i][0];
//                end = interval[i][1];
                count += (end - start);
            }
            if(i == interval.length - 1){
//                list.add(new int[]{start, end});
                count += (end - start);
            }
        }
        System.out.println(count);
    }
}
