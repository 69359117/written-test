
import java.io.*;
import java.util.*;

//    public class Main{
public class MeiTuan2 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = cin.nextInt();
        }
        int[] solution = solution(ints);



    }

    public static int[] solution(int[] ints){
        int[] res = new int[2];
        int min1 = Integer.MIN_VALUE, min2 = Integer.MIN_VALUE;
        for (int i : ints) {
            if(i<min1){
                min2 = min1;
                min1 = i;
            }else if(i<min2){
                min2 = i;
            }else {

            }


        }

        return res;
    }
}
