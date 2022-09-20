package xiaohongshu;

import java.util.Scanner;

//2
//3
//51 52 51
//4
//51 52 52 51

public class xunlei2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if(T==0){
            System.out.println(0);
        }
        while(T > 0){
            T--;
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            System.out.println(solution(nums));
        }

    }

    public static int solution(int[] nums){
        int res = 1;
        int n = nums.length;
        for (int i = 0; i <= 2*n-2; i++) {
            int l = i/2 , r = l+i%2;
            int tem;
            if(l==r){
                tem = -1;
            }else {
                tem = 0;
            }
            while (l>=0 && r<n && nums[l] == nums[r]){
                if(l!=r && nums[l]>nums[l+1]){
                    break;
                }
                l--;
                r++;
                tem+=2;
                res = Math.max(res,tem);
            }
        }
        return res;
    }

}
