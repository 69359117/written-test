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
//        HashSet<Integer> set = new HashSet<>();
        int[] hash = new int[100000000];
        for (int i = 0; i < n; i++){
            num[i] = sc.nextInt();
//            set.add(num[i]);//把输入每一个数放入set里面
            hash[num[i]] = 1;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
//            set.remove(num[i]);//删除当前数
            hash[num[i]] = 0;
            for(int j = 0; j <= 1000000000; j++){//从0开始遍历，看看缺了哪个
                if(hash[j] != 1){
                    res[i] = j;
                    break;
                }
            }
//            set.add(num[i]);//加回来当前数
            hash[num[i]] = 1;
        }
        for(int k : res) System.out.print(k+ " ");
    }
}
