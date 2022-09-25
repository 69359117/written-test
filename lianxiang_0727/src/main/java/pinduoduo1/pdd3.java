package pinduoduo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
2
4 1 3
x**x
2 4 3
x*

*/


public class pdd3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int l = sc.nextInt();
            int m = sc.nextInt();
            long n = sc.nextInt();
            String s = sc.next();
            Solution(s,l,m,n);
        }
    }

    // m：替换成 0—m 个 y ； 可以视为 进制数
    // n：要求第 n 小的
    public static void Solution(String s , int l , int m ,long n) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;
        for (char c : chars) {
            if(c=='*'){
                num++;
            }
        }
        long[] nums = new long[num];
        long[] count = new long[num];
        long tem = 1 ;
        for (int i = num-1; i >= 0 ; i--) {
            count[i] = tem;
            tem *= m;
        }
        for (int i = 0; i < num; i++) {
            if(n >= count[i]){
                long tem2 = n/count[i];
                nums[i] = tem2;
                n = n%count[i];
            }
        }

        int num_xing = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'x'){
                stringBuilder.append('x');
            }else {
                for (int j = 1; j <= count[num_xing]; j++) {
                    stringBuilder.append('y');
                }
                num_xing++;
            }
        }
        System.out.println(stringBuilder.toString());
    }

}

