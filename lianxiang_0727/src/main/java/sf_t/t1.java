package lianxiang_0727.src.main.java.sf_t;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-07 18:59
 */
/*
5 3
1 2 3 4 5

5 4
1 2 3 4 5

10 9
1 19 13 4 16 12 5 8 14 6
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n种类型
        int m = sc.nextInt();//要求m道不同类型的题
        int[] nums = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            queue.add(nums[i]);
        }

        int count = 0;

        while(true){
            int[] temp = new int[m];
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                temp[i] = queue.poll() - 1;
                if(i == m - 1 && temp[i] < 0){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            for (int i = 0; i < m; i++) {
                queue.add(temp[i]);
            }
            count++;
        }
        System.out.println(count);
    }
}
