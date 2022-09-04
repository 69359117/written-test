package lianxiang_0727.src.main.java.wytjh;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;
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
        int minValue = Integer.MAX_VALUE;//最初的最小值
        int minIndex = -1;
        int count = Integer.MIN_VALUE;//最初的相等个数
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            maxValue = Math.max(maxValue, nums[i]);
            if(nums[i] < minValue){
                minValue = nums[i];
                minIndex = i;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();//key是值，val是次数
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            count = Math.max(count, map.get(nums[i]));
        }
        if(count == n){
            System.out.println(n);
            return;
        }

        while(minValue < maxValue){
            map.put(minValue, map.get(minValue) - 1);
            nums[minIndex] += k;
            map.put(nums[minIndex], map.getOrDefault(nums[minIndex], 0) + 1);
            count = Math.max(count, Math.max(map.get(minValue), nums[minIndex]));
            //更新minIndex 和 minvalue
            minValue = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(nums[i] < minValue){
                    nums[i] = minValue;
                    minIndex = i;
                }
            }
        }
        System.out.println(count);
    }
}
