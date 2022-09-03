package zhongxing0901;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tdd
 * @creat 2022-09-01 18:47
 * 题目：
 * 2、真约数是指能够整除这个数的数（除自身以外），例如28的真约数为1，2，4，7，14。
 * 若一个数n的真约数之和小于n，则称之为亏数；反之，则称之为盈数。
 * 由于12是最小的盈数，它的真约数之和为1+2+3+4+6=16，所以最小的能够表示成两个盈数之和的数是24。
 * 通过数学分析可以得出，所有大于28123的数都可以被写成两个盈数的和；尽管已知最大的不能被写成两个盈数之和的数要小于这个值，但这是仅通过分析所能得到的最好上界。
 * 求所有不能被写成两个盈数之和的正整数之和。
 */

//思路：找到全部盈数，作为list存储。遍历1~28123所有数字，判断是否为两个盈数之和，如果不是加和当前数
public class t2 {
    public static void main(String[] args) {
        int definiteValue = 28123;
        List<Integer> yingList = new ArrayList<>();//盈数list，从小到大
        for (int i = 1; i <= definiteValue; i++) {
            if (isYingNum(i)) yingList.add(i);
        }

        long res = 0;
        for (int i = 0; i <= definiteValue; i++) {//i代表当前数，开始遍历
            boolean isYing = false;
            int p = 0, q = yingList.size() - 1;//左右界双指针
            while (p <= q) {
                int val = yingList.get(p) + yingList.get(q);
                if (i > val) {//当前数字大于两盈数之和 则取下一个更大的盈数 让p++
                    p++;
                } else if (i < val) {//当前数字大于两盈数之和 则取上一个更小的盈数 让q++
                    q--;
                } else {//i等于两盈数之和
                    isYing = true;
                    break;
                }
            }
            if (!isYing) {
                res += i;//不为盈数则加和到res中
            }
        }
        System.out.println("所有非盈数之和为：" + res);
    }

    //函数①：求是否为盈数
    public static boolean isYingNum(int n) {
        int sum = 0;
        for (int i = 1; i <= (n / 2); i++) {
            if (n % i == 0) {//把约数加进去
                sum += i;
            }
        }
        boolean flag = sum > n;
        return flag;
    }
}

