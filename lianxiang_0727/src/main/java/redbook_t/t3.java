package lianxiang_0727.src.main.java.redbook_t;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Tdd
 * @creat 2022-09-19 16:56
 */
/*
6 2
1 2 1 3 2 3
 */
public class t3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        int count = 0;
        for (int i = 0; i < n - k + 1; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxTime = 0;
            for (int j = i; j < n; j++) {
//                if (j - i + 1 < k) continue;

                int temp = map.getOrDefault(nums[j], 0) + 1;
                map.put(nums[j], temp);
                maxTime = Math.max(maxTime, temp);
                if(maxTime >= k){
                    count += (n - j);
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isRight(int[] nums, int i, int j, int k) {
        if (j - i + 1 < k) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxTime = 0;
        for (int l = i; l <= j; l++) {
            int temp = map.getOrDefault(nums[l], 0) + 1;
            map.put(nums[l], temp);
            maxTime = Math.max(maxTime, temp);
        }
        if(maxTime < k) return false;
        else return true;

    }
}
