package lianxiang_0727.src.main.java.wytjh;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-04 15:07
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        int maxValue = Integer.MIN_VALUE;//最初的最大值
        int count = Integer.MIN_VALUE;//最初的相等个数
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            maxValue = Math.max(maxValue, nums[i]);
        }
        Arrays.sort(nums);
        int temp = 1;
        for (int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i+1]) temp++;
            else temp = 1;
            count = Math.max(count, temp);
        }
        if(count == n){
            System.out.println(n);
            return;
        }

        while(nums[0] < maxValue){
            nums[0] += k;
            Arrays.sort(nums);
            temp = 1;
            for (int i = 0; i < n - 1; i++) {
                if(nums[i] == nums[i+1]) temp++;
                else temp = 1;
                count = Math.max(count, temp);
            }
        }
        System.out.println(count);
    }
}
