package lianxiang_0727.src.main.java;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-08-28 17:04
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//技能数量
        Long K = sc.nextLong();//威力需求
        int[] power = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }
        Arrays.sort(power);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = i+1, r = n;
            while(l < r){
                int mid = (r-l)/2+l;
                if(mid == i) 
                if(power[i]*power[mid] < K){
                    l = mid + 1;
                }else if(power[i]*power[mid] >= K){
                    r = mid;
                }
            }
            res += (n - l);
        }
        System.out.println(res);
    }
}
