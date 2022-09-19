package lianxiang_0727.src.main.java.redbook_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-19 15:45
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt(), a2 = sc.nextInt(), a3 = sc.nextInt()
                , a4 = sc.nextInt(), x = sc.nextInt();
        int[] num1 = new int[a1];
        int counta = 0;
        for (int i = 0; i < a1; i++){
            num1[i] = sc.nextInt();
            if(num1[i] > x) counta++;
        }

        int[] num2 = new int[a2];
        int countb = 0;
        for (int i = 0; i < a2; i++){
            num2[i] = sc.nextInt();
            if(num2[i] > x) countb++;
        }

        int[] num3 = new int[a3];
        int countc = 0;
        for (int i = 0; i < a3; i++){
            num3[i] = sc.nextInt();
            if(num3[i] > x) countc++;
        }

        int[] num4 = new int[a4];
        int countd = 0;
        for (int i = 0; i < a4; i++){
            num4[i] = sc.nextInt();
            if(num4[i] > x) countd++;
        }
        System.out.println(Math.min(Math.min(counta, countb), Math.min(countc, countd)));

    }
}
