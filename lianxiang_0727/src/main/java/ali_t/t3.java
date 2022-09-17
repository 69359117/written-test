package lianxiang_0727.src.main.java.ali_t;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-16 18:49
 */



public class t3{
    static HashMap<Integer, Integer> map;
    static HashMap<Integer, Integer> maxMap;
    static HashMap<Integer, Integer> minMap;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        int countMin = 0, countMax = 0;
        for(int i = 0; i < n; i++){
            if(num[i] == min) countMin++;
            if(num[i] == max) countMax++;
        }

        int count = 0;


        while(max - min != 1){
            if(countMin > 0 && countMin <= countMax){
                countMin--;
                count++;
                continue;
            }
            if(countMin == 0){
                for(int i = 0; i < n; i++){
                    if(num[i] == min) num[i]++;
                }
                min = findMin(num);
                countMin = map.get(min);
                continue;
            }

            if(countMax > 0 && countMin > countMax){
                countMax--;
                count++;
                continue;
            }
            if(countMax == 0){
                for(int i = 0; i < n; i++){
                    if(num[i] == max) num[i]--;
                }
                max = findMax(num);
                countMax = map.get(max);
                continue;
            }

        }
//         PriorityQueue<Integer> queue = new PriorityQueue();

        System.out.println(count);
    }


    public static int findMin(int[] num){
        map = new HashMap();
        int min = Integer.MAX_VALUE, n = num.length;
        for(int i = 0; i < n; i++){
            min = Math.min(min, num[i]);
            map.put(num[i], map.getOrDefault(num[i], 0) + 1);
        }
        return min;
    }

    public static int findMax(int[] num){
        map = new HashMap();
        int max = Integer.MIN_VALUE, n = num.length;
        for(int i = 0; i < n; i++){
            max = Math.max(max, num[i]);
            map.put(num[i], map.getOrDefault(num[i], 0) + 1);
        }
        return max;
    }

    public static int findcount(int[] num, int max){
        int count = 0, n = num.length;
        for(int i = 0; i < n; i++){
            if(num[i] == max) count++;
        }
        return count;
    }
}





// import java.util.*;

// public class Main{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] num = new int[n];

//         for(int i = 0; i < n; i++){
//             num[i] = sc.nextInt();
//         }

//         solution(num);
//     }

//     public static void solution(int[] ints){
//         Arrays.sort(ints);
//         if(ints[0] == ints[ints.length - 1]){
//             System.out.println(1);
//         }
//         int n = ints[0];

// //         int n = 1;
//         int l = -1, r = ints.length;
//         for(int i = 0; i < ints.length; i++){
//             if(ints[i] < n) l++;
//             else if(ints[i] > n+1){
//                 r = i;
//                 break;
//             }
//         }
//         long ans = 0;
//         for(int i = 0; i <= l; i++){
//             ans += (n - ints[i]);
//         }
//         for(int i = r; i < ints.length; i++){
//             ans += ints[i] - (n+1);
//         }
//         long tem = ans;
//         n++;

//         for(; n <= ints[ints.length - 1]; n++){
//             while(l+1 < ints.length && ints[l+1] < n) l++;
//             tem += l + 1;
//             while(r+1 < ints.length && ints[r+1] <= n+1) r++;
//             tem -= (ints.length - r);
//             ans = Math.min(ans, tem);
//         }
//         System.out.println(ans);
//     }

// }
