package Old;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-08-28 17:32
 */
public class t3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0, i = 0;
        while(i < 5){
            if(Math.random() < 0.5) res++;
        }
        System.out.println(res);
    }
}
