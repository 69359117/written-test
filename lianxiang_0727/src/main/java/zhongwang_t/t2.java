package lianxiang_0727.src.main.java.zhongwang_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-17 23:17
 */
/*

3 6 0.000001
20 10000 0.000001
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        double tol = sc.nextDouble();
//        System.out.println(m+","+n+","+tol);
        double x = 100;
        double e = Math.E;
        while(true){
            if(Math.abs(Math.pow(e, x) + Math.pow(x, m) - (double)n) >= tol) x = x/2;
            else break;

            System.out.println(x);
            if(x == 0.0) break;
        }
        System.out.println(x);
    }
}


