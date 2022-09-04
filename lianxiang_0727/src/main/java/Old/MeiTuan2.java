package Old;

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
        for (int i : ints) {            // 记录出现过的数
            if(i>=has.length){
                continue;
            }
            has[i] = true;
        }
        for (int i = 0; i < has.length; i++) {      // 遍历，找没有出现过的最小值min1
            if(!has[i]){
                min1 = i;
                break;
            }
        }
        for (int tem : ints) {
            if(tem <= min1){                // 删掉的比 min1 小、输出删除的数
                System.out.println(tem);
            }else {
                System.out.println(min1);   // 删掉的比 min1 小、输出min1
            }
        }
    }
}
