import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];            // 长度
        int[] last = {0, 0};                // 后半段颜色累积
        int[] pre = {0, 0};                 // 前半段颜色累积
        for (int i = 0; i < N; i++) {       // 先全部视作后半段
//            int color = scanner.next().charAt(0);
            char color = scanner.next().charAt(0);
            if(color == 114){
                nums[i] = 0;
                last[0] ++;
            }else if(color == 98){
                nums[i] = 1;
                last[1]++;
            }
        }
        System.out.println(count(nums, pre, last));
    }


    public static int count(int[] nums ,  int[] pre ,int[] last){
        if(last[0] == 0 && last[1]==0){         // 空数组
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        if(last[0]==0 || last[1] == 0){         // 全纯色
            return 0;
        }else {
            ans = Math.min(ans , Math.min(last[0],last[1]));
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){                     // 将元素从后半段、移到前半段；
                last[0]--;
                pre[0]++;
            }else {
                last[1]--;
                pre[1]++;
            }
            int tem = 0;
            if(last[0]!=0 && last[1] != 0){     // 不是纯色时，选择数量较少颜色、进行涂色
                tem += Math.min(ans , Math.min(last[0],last[1]));
            }
            if(pre[0]!=0 && pre[1] != 0){
                tem += Math.min(ans , Math.min(pre[0],pre[1]));
            }
            ans = Math.min(ans,tem);
        }
        return ans;
    }


}
