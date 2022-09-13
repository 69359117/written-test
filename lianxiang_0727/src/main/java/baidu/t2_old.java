package baidu;

import java.util.Scanner;

//5
//2 3 4 2 3

//6
//1 1 2 3 2 3


public class t2_old {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[] ints = new int[i];
        for (int n = 0; n < i; n++) {
            ints[n] = sc.nextInt();
        }
        solution(ints);

    }

    // ints：怪物生命值
    public static void solution(int[] ints){
        int sum = 0;
        int i = 0;
        while (i < ints.length) {
            if(ints[i] == 0){           // 怪物已死、向后推进
                i++;
                continue;
            }
            // 踏前斩 有收益 的条件：怪物伤血、累积mp
            while (i < ints.length-2 && ints[i]>=1 && ints[i+1] >=2 && ints[i+2] >=3){
                sum+=5;
                ints[i]-=1;
                ints[i+1]-=2;
                ints[i+2]-=3;
            }
            // 踏前斩 无收益，强力攻击、击杀当前怪物
            sum += ints[i];
            i++;
        }
        System.out.println(sum);
    }
}
