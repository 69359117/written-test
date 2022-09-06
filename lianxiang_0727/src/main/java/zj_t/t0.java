package lianxiang_0727.src.main.java.zj_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-06 19:06
 */
public class t0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.length() <= 1){
            System.out.println(-1);
            return;
        }
        int count = 0;
        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i) == '3') count++;
            else{
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }
}
