package lianxiang_0727.src.main.java.mayi_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-15 19:22
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//a的个数
        StringBuilder sb = new StringBuilder();
        int[] num = new int[26];
        num[0] = n;
        for (int i = 0; i < 25; i++) {
            while(num[i] > 1){
                num[i] -= 2;
                num[i+1] += 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            while(num[i] > 0){
                sb.append(Character.toChars(i +'a'));
                num[i]--;
            }
        }
        System.out.println(sb);

    }
}
