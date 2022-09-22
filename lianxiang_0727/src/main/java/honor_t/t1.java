package lianxiang_0727.src.main.java.honor_t;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-22 19:02
 */
//10,left hand
//50000,right hand
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int num = Integer.parseInt(str[0]);
        boolean leftFirst = false;
        if(str[1].charAt(0) == 'l') leftFirst = true;
        ArrayList<Integer> listLeft = new ArrayList<>();//放的是该手有小到大的排球序列
        ArrayList<Integer> listRight = new ArrayList<>();

        int count = num;
        int round = 0;
        while(count != 0){
            if(listLeft.size() == 0 && listRight.size() == 0) {//左侧开始
                listLeft.add(1);//左加1
                count -= listLeft.get(listLeft.size() - 1);
                if (count == 0) {
                    round++;
                    break;
                }

                listRight.add(1);//右加1
                count -= listRight.get(listRight.size() - 1);
                round++;
                if (count == 0) break;

            }else{//非开始时
                //左侧
                int temp = listLeft.get(listLeft.size() - 1) + listRight.get(listRight.size() - 1);
                if(temp > count) temp = count;
                listLeft.add(temp);
                count -= temp;
                if (count == 0) {
                    round++;
                    break;
                }
                //右侧
                int temp2 = listLeft.get(listLeft.size() - 1) + listRight.get(listRight.size() - 1);
                if(temp2 > count) temp2 = count;
                listRight.add(temp2);
                count -= temp2;
                round++;
                if (count == 0) break;
            }
        }

        if(leftFirst){//输出左侧序列
            System.out.println("now is " + round + " times by left hand");
            if(listLeft.size() == 0){
                System.out.println("left hand has not touch the ball");
                return;
            }

            int j = 0;
            for(int i : listLeft){
                if(j < 9){
                    System.out.print(i + " ");
                    j++;
                } else {
                    System.out.print(i);
                    System.out.println();
                    j = 0;
                }
            }
        }
        else{//输出右侧序列
            System.out.println("now is " + round + " times by right hand");
            if(listRight.size() == 0){
                System.out.println("right hand has not touch the ball");
                return;
            }

            int j = 0;
            for(int i : listRight){
                if(j < 9){
                    System.out.print(i + " ");
                    j++;
                } else {
                    System.out.print(i);
                    System.out.println();
                    j = 0;
                }
            }
        }
    }
}
