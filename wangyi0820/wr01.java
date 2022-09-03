package wangyi0820;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tdd
 * @creat 2022-08-25 19:07
 */
public class wr01 {
    public static void main(String[] args) {
        System.out.println(solution(15958));
    }

    public static int solution(int N){
        boolean flag = false;
        if(N < 0){//把负数变成正数，如果flag是true，相当于找正整数N最小的;false则找最大值
            flag = true;
            N = -N;
        }
        int res = find(N, flag);
        if(flag) res = -res;
        return res;
    }

    public static int find(int N, boolean flag){
        StringBuilder strN = new StringBuilder(String.valueOf(N));
        List<Integer> index = new ArrayList<>();
        for(int i = 0; i < strN.length(); i++){
            if(strN.charAt(i) == '5') index.add(i);
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(flag){//找最小值
            for(Integer i : index){
                min = Math.min(min, Integer.parseInt(strN.deleteCharAt(i).toString()));
                strN.insert(i, "5");
            }
            return min;
        }else{//找最大值
            for(Integer i : index){
                max = Math.max(max, Integer.parseInt(strN.deleteCharAt(i).toString()));
                strN.insert(i, "5");
            }
            return max;
        }

    }
}
