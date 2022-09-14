package Old;

import java.util.Comparator;

/**
 * @author Tdd
 * @creat 2022-09-12 0:15
 */
public class t01 {
    public static void main(String[] args) {
        String[] strs = new String[]{"QWER","1","1","666","QWER"};
        System.out.println(minDistance(strs, "QWER", "666"));
    }

//    public int minDistance(String[] strs, String str1, String str2){
//        int[] arr = new int[strs.length];
//        for (int i = 0; i < strs.length; i++) {
//            if(strs[i].equals(str1)) arr[i] = 1;
//            if(strs[i].equals(str2)) arr[i] = 2;
//        }
//
//        return 0;
//    }

    //字符串数组中两个字符串的最小距离
    public static int minDistance(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        int last1 = -1;//最近一次str1的位置
        int last2 = -1;//最近一次str2的位置
        int min = Integer.MAX_VALUE;//距离
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str1)) {//找到了str1，如果找到了last2,则i-last2就是当前str1和左边最近str2的距离
                min = Math.min(min, last2 == -1 ? min : i - last2);//每次都要比较Min
                last1 = i;
            }
            if (strs[i].equals(str2)) {//找到了str2，如果找到了last1,则i-last1就是当前str2和左边最近str1的距离
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
}
