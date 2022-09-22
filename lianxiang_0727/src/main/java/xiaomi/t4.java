package lianxiang_0727.src.main.java.xiaomi;

/**
 * @author Tdd
 * @creat 2022-09-21 19:24
 */
public class t4 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, i = 0, sum = 0;
        while (i < nums.length) {
            if (sum + nums[i] < nums[i]) {
                sum = 0;
            }
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            i++;
        }
        return max;
    }
}
