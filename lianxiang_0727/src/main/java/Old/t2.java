//package lianxiang_0727.src.main.java;
//
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @author Tdd
// * @creat 2022-08-28 17:04
// */
//public class t2 {
//
//
//    public static void main(String[] args) {
//        new Thread();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();//技能数量
//        Long K = sc.nextLong();//威力需求
//        int[] power = new int[n];
//        for (int i = 0; i < n; i++) {
//            power[i] = sc.nextInt();
//        }
//        Arrays.sort(power);
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            if(i-1>=0 && power[i]==power[i-1]){
//                continue;
//            }
//            int tem = find(power, i , K );
//            res+=tem;
//        }
//        System.out.println(res);
//    }
//
//    public static int find(int[] power, int i ,Long K){
//        int l = i;
//        int r = power.length;
//        while ( l <= r){
//            int mid = (l+r)/2;
//            int tem = power[mid];
//            if(power[i] * tem >= K){
//                r = mid-1;
//            }else {
//                l = mid+1;
//            }
//        }
//        return 0;
//    }
//
//}
