package xiaohongshu;

import java.util.ArrayList;
import java.util.Scanner;

//9 8 17 6


public class xunlei1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int tem;
//        && tem=sc.nextInt()
        while (sc.hasNext()  ) {
            list.add(sc.nextInt());
        }
        Solution(list);
    }


    public static void Solution(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        int avg = sum / list.size();
        int res = list.size();
        int tem = 0;            // 暂时总数
        int num = 0;            // 内部元素数量
        for (Integer i : list) {
            tem += i;
            num++;
            if (tem != 0 && tem == avg * num) {
                res--;
                num = 0;
                tem = 0;
            }
        }
        System.out.println(res);
    }

}
