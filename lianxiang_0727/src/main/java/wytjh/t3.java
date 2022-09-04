package lianxiang_0727.src.main.java.wytjh;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-04 16:20
 */
public class t3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();//次数
        int x = sc.nextInt();//-x
        int[] nums = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2-o1));
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int[] d = new int[n];
        int min = nums[n-1], w = 0;
        for (int i = n-2; i >= 0; i--) {
            int q = (min - nums[i]) / x;

            w += q * (n - i - 1);
            if(w >= k) break;
            d[i + 1] = q;
        }
        for (int i = 1; i < n; i++) {
            d[i] = d[i - 1] + d[i];
//            System.out.println(d[i]);
            k -= d[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - d[i] * x;
            queue.add(nums[i]);
        }

        while(k > 0){
            k--;
            Integer temp = queue.poll();
            temp -= x;
            queue.add(temp);
        }
        System.out.println(queue.poll());
    }
}
