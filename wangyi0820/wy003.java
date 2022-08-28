package wangyi0820;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-08-27 19:26
 */
public class wy003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        while(time > 0){
            time--;
            System.out.println((int)(Math.random()*100));
        }
    }
}
