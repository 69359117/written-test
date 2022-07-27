import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        int[] last = {0, 0};
        int[] pre = {0, 0};
        for (int i = 0; i < N; i++) {
            int color = scanner.nextInt();
            if(color == 0){
                nums[i] = 0;
                last[0] ++;
            }else {
                nums[i] = 1;
                last[1]++;
            }
        }

        System.out.println(count(nums, pre, last));

    }


    public static int count(int[] nums ,  int[] pre ,int[] last){
        if(last[0] == 0 && last[1]==0){         // 空
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        if(last[0]==0 || last[1] == 0){         // 纯色
            return 0;
        }else {
            ans = Math.min(ans , Math.min(last[0],last[1]));
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                last[0]--;
                pre[0]++;
            }else {
                last[1]--;
                pre[1]++;
            }
            int tem = 0;
            if(last[0]!=0 && last[1] != 0){     // 不是纯色
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
