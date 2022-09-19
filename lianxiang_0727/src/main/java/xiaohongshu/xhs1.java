package xiaohongshu;

import java.util.HashMap;
import java.util.Scanner;

//6 2
//1 2 1 3 2 3


public class xhs1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = sc.nextInt();
        }

        Solution(ints, k);

    }


    public static void Solution(int[] ints, int k) {
        int ans = 0;
        int t = ints.length - k +1;
        for (int i = 0; i < t; i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int max = 0;
            for (int j = i; j < ints.length; j++) {
                Integer tem = map.getOrDefault(ints[j], 0);
                map.put(ints[j], tem + 1);
                max = Math.max(max, tem + 1);
                if (max >= k) {
                    System.out.println((i + " " + j));
                    ans += (ints.length - j);
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}