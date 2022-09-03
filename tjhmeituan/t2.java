package tjhmeituan;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-03 10:21
 */
/*
4
5 0 3 1
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            num[i] = sc.nextInt();
            set.add(num[i]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            set.remove(num[i]);
            for(int j = 0; j <= 1000000000; j++){
                if(!set.contains(j)){
                    res[i] = j;
                    break;
                }
            }
            set.add(num[i]);
        }
        for(int k : res) System.out.print(k+ " ");


    }
}
