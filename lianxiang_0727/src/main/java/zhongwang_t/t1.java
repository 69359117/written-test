package lianxiang_0727.src.main.java.zhongwang_t;

/**
 * @author Tdd
 * @creat 2022-09-17 22:36
 */
public class t1 {
}

class Solution {
    public int jump(int[] nums) {

        int count = 0;
        int l = 0, r = 0;//当前跳的左右边界
        int i = 0;//i作为每次跳的位置

        while(i < nums.length - 1){
            count++;
            l = i + 1;//当前跳可达的左边界
            r = i + nums[i];//当前跳可达的右边界
            if(r >= nums.length - 1) return count;

            int cover = 0;// 下一次跳的最大右边界【最大范围】
            for(int j = l; j <= r; j++){
                if(j + nums[j] > cover){
                    if(cover >= nums.length - 1) return count+1;
                    if(nums[j] == 0) continue;//在没到达的情况下nums[j]不能为0
                    cover = j + nums[j];//能跳更大范围
                    i = j;//下一次的起跳位置
                }

            }
        }
        return 0;
    }
}
