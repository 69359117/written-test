//package wangyi0820;
//
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
///**
// * @author Tdd
// * @creat 2022-08-27 19:26
// */
//
//public class wy002 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int time = sc.nextInt();
//        for (int i = 0; i < time; i++) {
//            int n = sc.nextInt(), res = 0;
//            int[][] res = new int[n][4];
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < 4; k++) {
//                    res[j][k] = sc.nextInt();
//                }
//            }
//            Set<Integer> set = new HashSet<>();
//            for (int j = 0; j < n; j++) {
//                if (set.contains(j)) continue;//计算过的不再算
//                for (int k = j + 1; k < n; k++) {
//                    if (set.contains(k)) continue;//计算过的不再算
//                    if (isVaild(res[j], res[k])) {
//                        set.add(j);
//                        set.add(k);
//                        res += vaildSize(res[j], res[k]);
//                        break;
//                    }
//                }
//            }
//            System.out.println(res);
//        }
//    }
//
//    public static int vaildSize(int[] a1, int[] a2) {//计算有效面积
//        int res = (a2[3] - a2[1]) * (a2[2] - a2[0]);
//        res += (a1[3] - a1[1]) * (a1[2] - a1[0]);
//        int x1 = Math.max(a1[0], a2[0]), x2 = Math.min(a1[2], a2[2]);
//        int y1 = Math.max(a1[1], a2[1]), y2 = Math.min(a1[3], a2[3]);
//        res -= (y2 - y1) * (x2 - x1);//重复部分
//        return res;
//    }
//
//    public static boolean isVaild(int[] a1, int[] a2) {//要重叠才算有效
//        return (Math.min(a1[2], a2[2]) > Math.max(a1[0], a2[0]))
//                && (Math.min(a1[3], a2[3]) > Math.max(a1[1], a2[1]));
//    }
//}
