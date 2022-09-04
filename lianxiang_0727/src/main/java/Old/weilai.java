package Old;

import java.util.Scanner;

public class weilai {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];            // 长度

        for (int i = 0; i < N; i++) {       // 先全部视作后半段
            nums[i] = scanner.nextInt();
        }

        System.out.println( count(nums, 0, nums.length-1) );

    }

    public static int count(int[] nums, int i ,int j){

        if(i>j || i >= nums.length){
            return 0;
        }

        int ans = 0 ;

        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int k = i; k <= j; k++) {
//            System.out.println(i);
//            System.out.println(j);
//            System.out.println(k);
            if(min > nums[k]){
                min = nums[k];
                min_index = k;
            }

        }

        for (int k = i; k <= j; k++) {
            nums[k] -= min;
        }


        return min + count(nums,i,min_index-1) + count(nums,min_index+1,j);
    }

}
