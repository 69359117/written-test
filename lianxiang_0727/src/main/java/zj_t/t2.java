package lianxiang_0727.src.main.java.zj_t;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-04 19:18
 */
/*
4
3
-1 0 1
5
1 -2 -2 1 -3
6
0 0 0 0 0 0
4
-1 2 -3 4
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//组数
        while(t > 0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
            System.out.println(solution(nums) ? "YES" : "NO");
            t--;
        }
    }

    public static boolean solution(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        for(int i = 0; i < nums.length - 2; i++){
//            if(set.contains(nums[i] + nums[i+1] + nums[i+2])) return true;
//            if(i > 0 && nums[i] == nums[i-1]) continue;//剪枝1：当前数字i  作为重复的数字跳过
            for (int j = i + 1; j < nums.length - 1; j++) {
//                if(j > 0 && nums[j] == nums[j-1]) continue;
                for (int k = j + 1; k < nums.length; k++) {
//                    if(k > 0 && nums[k] == nums[k-1]) continue;
                    if(set.contains(nums[i] + nums[j] + nums[k])) return true;
                }
            }
        }
        return false;
    }
}
