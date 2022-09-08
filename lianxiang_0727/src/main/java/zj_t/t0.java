package lianxiang_0727.src.main.java.zj_t;

import java.util.Scanner;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;

/**
 * @author Tdd
 * @creat 2022-09-06 19:06
 */
public class t0 {
    public static void main(String[] args) {
//        new ExecutorService()
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // 不合法输入的前置检测
        if (input.length() <= 1 || input.charAt(0) != '1') {
            System.out.println(-1);
            return;
        }
        int count = 0;          // 1 后面 3 的数量
        for (int i = 1; i < input.length(); i++) {      // 遍历后续字符
            if (input.charAt(i) == '3') count++;        // 判断是否是 ’3‘
            else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }
}
