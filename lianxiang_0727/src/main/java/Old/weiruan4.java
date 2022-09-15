package Old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class weiruan4 {

    public static void main(String[] args) {

        int[] A1 = {-3, -2, 1, 0, 8, 7, 1};
        System.out.println( Solution(A1, A1.length, 3) );

        int[] A2 = {7,1,11,8,4,10};
        System.out.println( Solution(A2, A2.length, 8) );

        int[] A3 = {};
        System.out.println( Solution(A3, A3.length, 8) );

//        int[] A4 = {7,1,11,8,4,10};
//        System.out.println( Solution(A4, A4.length, 0) );

    }

    // A：给定数组 ； N：数组长度 ； M ：给定除数
    public static int Solution(int[] A, int N, int M) {
        int[] ints = new int[M];

        for (int i : A) {
            int tem = i%M;
            if(tem<0) tem+=M;
            ints[tem]++;
        }

        int res = 0;
        for (int anInt : ints) {
            res = Math.max(anInt,res);
        }
        return res;


//        if(M==0){
//            return 0;
//        }
//
//        int res = 0;
//
//        HashMap<Integer, Integer> map = new HashMap<>();        // 某个值，以及对应子集中的元素数量
//
//        for (int i : A) {
//            for ( int num : map.keySet() ) {            // 遍历现有 子集
//                if( (i-num) % M == 0){                  // 如果能整除，加入该子集
//                    map.put(num,map.get(num)+1);
//                    break;
//                }
//            }
//            map.put(i,1);                               // 都不能整除，创建新子集
//        }
//
//        for (int value : map.values()) {                // 遍历所有子集，找出元素数量最多的子集
//            res = Math.max(res,value);
//        }
//
//        return res;
    }

//    int res = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE ;
//
//        // map：记录数组中元素的 [数值，出现次数]
//        for (int i : A) {
//            // min、max：记录 数组中元素的极值
//            if(i<min){
//                min = i;
//            }
//            if(i>max){
//                max = i;
//            }
//            int tem = map.getOrDefault(i, 0);
//            map.put(i, tem + 1);
//        }
//
//        // 遍历数组中的元素
//        for (int i : A) {
//            int num = map.getOrDefault(i,0);        // num：当前数字在map中记录的出现次数
//            if(num == 0 ){              // 当前数值 已经考虑过、跳过本轮
//                continue;
//            }
//            int tem = i-M;              // 向下寻找极值
//            while ( tem >= min ){       // 只要没有小于最小值，到 map 中找出现的次数
//                int num1 = map.getOrDefault(tem,0);
//                if(num1==0){
//                    tem -= M;
//                    continue;
//                }else {
//                    num += num1;            // 出现次数不为 0 时，累加num、并从map中移除
//                    map.remove(tem);
//                    tem -= M;
//                }
//            }
//            tem = i+M;                      // 向上寻找极值，同理
//            while ( tem <= max ){
//                int num1 = map.getOrDefault(tem,0);
//
//                if(num1==0){
//                    tem += M;
//                    continue;
//                }else {
//                    num += num1;
//                    map.remove(tem);
//                    tem += M;
//                }
//            }
//            if(num > res){                  // 更新 res 的 最大值
//                res = num ;
//            }
//        }
//        return res;


}
