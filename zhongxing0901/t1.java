package zhongxing0901;

/**
 * @author Tdd
 * @creat 2022-09-01 18:47
 * 题目：
 * 1、毕达哥拉斯三元组由三个自然数a<b<c组成，并满足
 * a^2+b^2=c^2
 * 例如，3^2+4^2=9+16=25=5^2。
 * 有且只有一个毕达哥拉斯三元组满足 a+b+c=1000。求这个三元组的乘积abc。
 */

//思路：两层遍历，找到满足条件条件是a<b<1000-a-b 且 a^2+b^2=(1000-a-b)^2的三元组
public class t1 {
    public static void main(String[] args) {
        int a, b;
        //可以剪枝，条件是a<b<c
        for (a = 0; a < 1000; a++) {
            for (b = a + 1; b < 1000; b++) {
                if (a * a + b * b == (1000 - a - b) * (1000 - a - b) && (1000 - a - b) > b) {//条件是a<b<c 且 a^2+b^2=c^2
                    System.out.println("a = " + a + ", b = " + b + ", c = " + (1000 - a - b));
                    System.out.println("唯一的三元组乘积a*b*c = " + a * b * (1000 - a - b));
                }
            }
        }
    }
}
