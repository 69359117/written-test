package xiaohongshu;

import java.util.Collection;
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
        int t = ints.length - k + 1;
        int max = 0;
//        int max1 = 0;
//        int max2 = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int j = 0;
        for (; j < ints.length; j++) {
            Integer tem = map.getOrDefault(ints[j], 0);
            map.put(ints[j], tem + 1);
            max = Math.max(max, tem + 1);

//            if(tem+1>=max1){
//                max1 = tem+1;
//                max2 = max1;
//            }else if(tem+1 > max2){
//                max2 = tem+1;
//            }

            if (max >= k) {
//                System.out.println((i + " " + j));
                ans += (ints.length - j);
                break;
            }
        }

        for (int i = 1; i < t; i++) {
            Integer tem = map.get(ints[i - 1]);
            map.put(ints[i-1], tem - 1);
            Collection<Integer> values = map.values();
            max = 0;
            for (Integer value : values) {
                max = Math.max(max, value);
            }
            if (max >= k) {
                ans += (ints.length - j);
                continue;
            }

            for (j++; j < ints.length; j++) {
                tem = map.getOrDefault(ints[j], 0);
                map.put(ints[j], tem + 1);
                max = Math.max(max, tem + 1);
                if (max >= k) {
//                    System.out.println((i + " " + j));
                    ans += (ints.length - j);
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}