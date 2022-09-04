package lianxiang_0727.src.main.java.zj_t;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tdd
 * @creat 2022-09-04 19:43
 */

/*
3 3 3
2 1 2
2 2 3
2 1 3
2 1 -2
2 2 -3
2 3 -1
 */
public class t4 {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = nums(cin.readLine());
        boolean[][] temp = new boolean[nums[0]][nums[1]];
        
        for (int i = 0; i < nums[0]; i++) temp[i] = getOne(cin.readLine(), nums[1]);
        
        for (int i = 0; i < nums[2]; i++) {
            int[] arr = nums(cin.readLine());
            int count = 0;
            for (int j = 0; j < nums[0]; j++) {
                boolean flag = true;
                for (int k = 1; k < arr.length; k++) {
                    int last = arr[k];
                    if ((last > 0 && temp[j][last - 1]) || (last < 0 && !temp[j][-last - 1])) continue;
                    else {
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }
            System.out.println(count);
        }
    }

    public static int[] nums(String s) {
        String[] s1 = s.split(" ");
        int[] out = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            out[i] = Integer.parseInt(s1[i]);
        }
        return out;
    }

    public static boolean[] getOne(String s, int M) {
        String[] s1 = s.split(" ");
        boolean[] out = new boolean[M];
        for (int i = 1; i < s1.length; i++) {
            out[Integer.parseInt(s1[i]) - 1] = true;
        }
        return out;
    }
}
