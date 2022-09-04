package lianxiang_0727.src.main.java.wytjh;

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
