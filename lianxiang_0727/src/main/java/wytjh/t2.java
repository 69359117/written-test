package lianxiang_0727.src.main.java.wytjh;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-04 15:54
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), t = sc.nextInt();//n长度，k个1，t对相邻的1
        if(k > n || t >= k){
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if(k > 0){
            sb.append(1);
            k--;
        }
        if(sb.length() < n){
            while(sb.length() != 0 && sb.charAt(sb.length() - 1) == '1' && t > 0 && k > 0){//优先处理对子t
                sb.append(1);
                t--;
                k--;
                if(sb.length() == n) break;
            }
            //t == 0跳出循环
            while(sb.length() < n && k > 0){
                sb.append(0);
                sb.append(1);
                k--;
            }
        }
        while(sb.length() < n) sb.append(0);
        System.out.println(sb);
    }
}
