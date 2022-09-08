
import java.util.Arrays;
import java.util.Scanner;

//6
//100 110 120 140 160 180

//3
//100 100 100

public class manbang2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        solution(points);

    }


    public static void solution(int[] points) {
        Arrays.sort(points);
        int min = -1;                               // 临时组内最低分（-1）
        int groupNum = 0;                           // 组数
        int groupStudentNum = 0;                    // 临时组内的人数
        for (int point : points) {
            if (min == -1) {                // 组内为空
                min = point;                // 组内最低分为 当前分数
                groupStudentNum++;          // 组内人数+1
                groupNum++;                 // 组数+1
                // 临时组内已有一人，加入组内的要求是分差<=20
            } else if (groupStudentNum == 1 && Math.abs((point - min)) <= 20) {
                groupStudentNum++;
                // 临时组内已有两人，加入组内的要求是分差<=10
            } else if (groupStudentNum == 2 && Math.abs((point - min)) <= 10) {
                min = -1;               // 临时组已满，清空临时组的属性信息
                groupStudentNum = 0;
            } else {        // 都不满足，需要新开一个临时组
                min = point;
                groupStudentNum = 1;
                groupNum++;
            }
        }
        System.out.println(groupNum);
    }

}
