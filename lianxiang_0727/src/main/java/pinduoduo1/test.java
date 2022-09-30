package pinduoduo1;
/*
*
科学家在研究新冠病毒的时候，发现病毒在不通温度下表现不同，
*为此，科学家随机产生了一个温度序列来为病毒做实验，请为科学家找出这个温度序列中的温度平衡点。
温度平衡点: 该温度的左侧的温度和与右侧的温度和相同。
注：如果存在多个温度平衡点，请返回序列中最靠后的温度平衡点。
示例1：
输入：[1,3,3,5,4,1,2]
输出：3 //温度为5的为温度平衡点，下标为 3
示例2：
输入：[1,1,1,1,1,1]
输出：-1 // 没有温度平衡点
示例3：
输入：[3, 2, -2]
输出：0 // 3 为温度平衡点，下标为0
输入：[0,3, 2, -2]
输出：1 // 3 为温度平衡点，下标为1
*
*
* */


public class test {

    public static void main(String[] args) {

        int[] ints = {1, 3, 3, 5, 4, 1, 2};
        solution(ints);

        int[] ints2 = {1, 1, 1, 1, 1, 1};
        solution(ints2);

        int[] ints3 = {3, 2, -2};
        solution(ints3);

        int[] ints4 = {0, 3, 2, -2};
        solution(ints4);
    }

    public static void solution(int[] ints) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i : ints) {
            leftSum += i;
        }

        for (int i = ints.length - 1; i >= 0; i--) {
            leftSum -= ints[i];
            if (i + 1 < ints.length) {
                rightSum += ints[i + 1];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
