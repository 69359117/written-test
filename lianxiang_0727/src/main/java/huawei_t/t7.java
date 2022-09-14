package lianxiang_0727.src.main.java.huawei_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-14 22:42
 */
public class t7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int cost = 0;
        while(k-1 > 0){
            int min = Math.min(n, m);
            int max = Math.max(n, m);
            m = min;
            n = max;
            cost += min * min;
            k--;
            if(k-1 <= min-1){
                cost += k-1;
                break;
            }else{
                cost += min - 1;
                k -= min - 1;
            }
            n = max - 1;
        }
        System.out.println(cost);
    }
}
