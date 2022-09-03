package tjhmeituan;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-03 9:49
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();//小美
        int b = sc.nextInt();//小团
        if(11 - b >= 2){//b分数小于等于9
            System.out.println(11 - a);
        }else {
            System.out.println(b+2-a);
        }

    }
}
