package wangyi0820;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-08-27 20:14
 */
public class wy010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();//墙纸长  正方形
            int M = sc.nextInt();//墙边长 M >= N
            String[] str = new String[N];
            sc.nextLine();
            for (int j = 0; j < N; j++) {
                str[j] = sc.nextLine();
            }

            int dinx = (M - 1)/2, zinx = (N-1)/2;
            while(dinx > 0){
                if(dinx > zinx){
                    dinx = dinx - zinx - 1;
                    zinx = N - 1;
                }else{
                    zinx = zinx - dinx;
                    dinx = 0;
                }
            }
            for(int k = 0; k < M; k++){
                StringBuilder sb = new StringBuilder();
                int dx = (zinx + k)% N;
                for (int j = 0; j < M; j++) {
                    int dy = (zinx + j)%N;
                    sb.append(str[dx].charAt(dy));
                }
                System.out.println(sb);
            }
            if(i != n-1) System.out.println();
        }
    }
}
