package JD0903;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-03 18:56
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] < max) res++;
        }
        System.out.println(res);
    }
}
