package lianxiang_0727.src.main.java.redbook_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-19 15:45
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), D = sc.nextInt();
        int x = sc.nextInt();
        int[] numsA = new int[A];
        int numA = 0;
        for (int i = 0; i < A; i++){
            numsA[i] = sc.nextInt();
            if(numsA[i] > x) numA++;
        }

        int[] numsB = new int[B];
        int numB = 0;
        for (int i = 0; i < B; i++){
            numsB[i] = sc.nextInt();
            if(numsB[i] > x) numB++;
        }

        int[] numsC = new int[C];
        int countc = 0;
        for (int i = 0; i < C; i++){
            numsC[i] = sc.nextInt();
            if(numsC[i] > x) countc++;
        }

        int[] numsD = new int[D];
        int countd = 0;
        for (int i = 0; i < D; i++){
            numsD[i] = sc.nextInt();
            if(numsD[i] > x) countd++;
        }
        System.out.println(Math.min(Math.min(numA, numB), Math.min(countc, countd)));

    }
}
