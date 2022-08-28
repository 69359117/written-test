//package wangyi0820;
//
//import java.util.Scanner;
//
///**
// * @author Tdd
// * @creat 2022-08-27 19:26
//3
//3 5
//1x1
//xox
//1x1
//
//3 7
//1x1
//xox
//1x1
//
//5 7
//13S31
//LKcKL
//Sc2cS
//LKcKL
//13S31
// */
//public class wy001 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            int N = sc.nextInt();//墙纸长  正方形
//            int M = sc.nextInt();//墙边长 M >= N
//            String[] str = new String[N];
//            sc.nextLine();
//            for (int j = 0; j < N; j++) {
//                str[j] = sc.nextLine();
//            }
//
//            int minus = M - N, halfMinus = (M - N) / 2;
//            StringBuilder sb = new StringBuilder(str[0]);//第一行
//            int index = 0, temp = halfMinus;
//            while(temp > 0){
//                char c = str[0].charAt(index);
//                sb.insert(index++, c);
//                sb.append(c);
//                temp--;
//            }
//            temp = halfMinus;
//            String s0 = sb.toString();
//
//            int l = 0;
//            while(l < halfMinus){
//                System.out.println(s0);
//                l++;
//            }
//            index = 0;
//            while(l >= halfMinus && l < halfMinus + N){
//                while(temp > 0){
//                    sb = new StringBuilder(str[l-halfMinus]);
//                    char c = str[l-halfMinus].charAt(index);
//                    sb.insert(index++, c);
//                    sb.append(c);
//                    temp--;
//                }
//                temp = halfMinus;
//                System.out.println(sb);
//                l++;
//            }
//            while(l >= halfMinus + N && l < M){
//                System.out.println(s0);
//                l++;
//            }
//            System.out.println();
//        }
//    }
//}
