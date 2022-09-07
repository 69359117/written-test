package lianxiang_0727.src.main.java.sf_t;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-07 18:59
 */
/*
5 3
1 2 3 4 5

5 4
1 2 3 4 5

10 9
1 19 13 4 16 12 5 8 14 6
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n种类型
        int m = sc.nextInt();//要求m道不同类型的题
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int count = 0;
        Arrays.sort(nums);
        while(nums[n-m] > 0){
            for (int i = 1; i <= m; i++) {
                nums[n-i]--;
            }
            count++;
            Arrays.sort(nums);
        }
        System.out.println(count);

    }
}
