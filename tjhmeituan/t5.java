package tjhmeituan;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-03 11:29
 */
/*
3
2 7 2
1 5 3
4 6 3
输出4
 */
public class t5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//总数
        int[] arr = new int[n];
        int[] brr = new int[n];
        int[] crr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < n; i++) brr[i] = sc.nextInt();
        for (int i = 0; i < n; i++) crr[i] = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {//选arr[i]
            for (int j = 0; j < n; j++) {//选brr[j]
                if(brr[j] <= arr[i]) continue;
                if(brr[j] > 2*arr[i]) continue;
                for (int k = 0; k < n; k++) {//选crr[k]
                    if(crr[k] <= brr[j]) continue;
                    if(crr[k] > 2*brr[j]) continue;
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
