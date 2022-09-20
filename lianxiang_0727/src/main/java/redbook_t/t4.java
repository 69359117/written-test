package lianxiang_0727.src.main.java.redbook_t;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-19 20:03
 */
/*
2
3
51 52 51
4
51 52 52 51
 */
//public class t4 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        while(T > 0){
//            T--;
//            int n = sc.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
//
//            System.out.println(solution(nums));
//        }
//
//    }
//
//    public static int solution(int[] nums){
//        int res = 0;
//        for (int i = 0; i < nums.length-1; i++) {
//            for (int j = nums.length - 1; j >= 1; j--) {
//                if(j - i + 1 <= res) break;
//                int count = 0;
//                int xt = i, yt = j;
//                while(xt < yt && nums[xt] == nums[yt] && nums[xt] <= nums[xt+1] && nums[yt-1] >= nums[yt]){
//                    count += 2;
//                    xt++;
//                    yt--;
//                }
//                if(xt == yt) count++;
////                if(count < res)
//                res = Math.max(res, count);
//                if(res == nums.length) return res;
//            }
//        }
//        return res;
//    }
//}

public class t4 {
    static int indexi = 0;
    static int indexj = 0;
    static int minus = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            System.out.println(longestPalindrome(nums));
        }

    }

    public static int longestPalindrome(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            extend(nums, i, i);
            extend(nums, i, i + 1);
            if(minus == nums.length - 1) return nums.length - 1;
        }
        return minus + 1;
    }

    public static void extend(int[] nums, int i, int j) {
        if (j < 1 || i >= nums.length - 1) return;
        while (i >= 0 && j < nums.length && nums[i] == nums[j] && nums[i] <= nums[i + 1] && nums[j - 1] >= nums[j]) {
            if (j - i > minus) {
                indexi = i;
                indexj = j;
                minus = j - i;
            }
            i--;
            j++;
        }

    }
}
