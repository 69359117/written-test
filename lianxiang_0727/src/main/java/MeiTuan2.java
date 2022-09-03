
import java.io.*;
import java.util.*;

//4
//5 0 3 1

//    public class Main{
public class MeiTuan2 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = cin.nextInt();
        }
        solution(ints);
    }

    public static void solution(int[] ints){

        boolean[] has = new boolean[ints.length+2];
        int min1 = Integer.MIN_VALUE;
        for (int i : ints) {
            has[i] = true;
        }
        for (int i = 0; i < has.length; i++) {
            if(!has[i]){
                min1 = i;
                break;
            }
        }

        for (int tem : ints) {
            if(tem <= min1){
                System.out.println(tem);
            }else {
                System.out.println(min1);
            }
        }
    }
}
