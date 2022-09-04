package Old;

import java.util.Scanner;

public class keda11 {

//10
//6 6 6 6 6 6 6 6 6 6


//    public class Main{
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        long[] ints = new long[n];
        for (int i = 0; i < n; i++) {
            ints[i] = cin.nextInt();
        }
        solution(ints);
    }

    public static void solution(long[] ints){
        int N = ints.length;
        long[] longs = new long[ints.length];

        for (int k = 0; k < ints.length; k++) {

            long tem1 = 0;
            for (int n = 0; n <= N - k-1; n++) {
                tem1 += ints[n] * ints[n+k];
            }

            for (int n = N-k; n <= N-1; n++) {
                tem1+= ints[n] * ints[n+k-N];
            }
            longs[k] = tem1;
        }

//        long max = Math.abs(ints[0]);
        for (long aLong : longs) {

            System.out.print(aLong+" ");
        }
        System.out.print("\n");

        long max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 1; i < longs.length; i++) {
            if(Math.abs(longs[i]) > max){
                max = Math.abs(longs[i]);
                maxIndex = i;
            }
        }
        boolean flag = false;
        for (int i = 1; i < longs.length; i++) {
            if(Math.abs(longs[i]) != max){
                flag = true;
                break;
            }
        }

        if(!flag){
            System.out.println("NO");
        }else {
            System.out.println(longs[maxIndex]);
        }
    }
}
