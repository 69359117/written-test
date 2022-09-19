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
public class t4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T > 0){
            T--;
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            System.out.println(solution(nums));
        }

    }
    
    public static int solution(int[] nums){
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int count = 0;
                int xt = i, yt = j;
                while(xt < yt && nums[xt] == nums[yt] && nums[xt] <= nums[xt+1] && nums[yt-1] >= nums[yt]){
                    count += 2;
                    xt++;
                    yt--;
                }
                if(xt == yt) count++;
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
