package lianxiang_0727.src.main.java.wytjh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Tdd
 * @creat 2022-09-04 15:45
 */
public class t1sg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();//key是值，val是次数
        for (int i = 0; i < n; i++) {
            int x = nums[i] % k;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int res = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : entries){
            res = Math.max(res, entry.getValue());
        }
        System.out.println(res);
    }
}
