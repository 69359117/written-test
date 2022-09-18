package lianxiang_0727.src.main.java.keyu_zj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-18 10:16
 */

/*
3
2 100 280
2 190 360
2 150 360

5
5 0 1000 2000 3010 3200
4 40 1050 2049 3100
1 80
1 120
1 160
 */

public class t1 {
    static List<int[]> now;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n层
        now = new ArrayList<>();
        int k = 0;
        while(k < n){
            k++;
            int[] temp = new int[sc.nextInt()];
            for (int i = 0; i < temp.length; i++) temp[i] = sc.nextInt() + 50;//重心
            now.add(temp);
        }
        int count = 0;
        count += now.get(0).length;
        k = 1;
        while(k < n){
            count += solution(k);
            k++;
        }
        System.out.println(count);
    }

    public static int solution(int k){//第k行有几个 k>=1
        int[] below = now.get(k - 1);//下一层
        int[] cur = now.get(k);//当前层
        int count = 0;
        int j = 0;
        for (int i = 0; i < cur.length; i++) {
            while(j < cur.length - 1){
                if(below[j] < 0){//非法情况
                    j++;
                    continue;
                }

                if(Math.abs(below[j]-cur[i]) <= 50){//单个的，左侧or右侧的
                    count++;
                    break;
                }

                if(cur[i] >= below[j] && cur[i] <= below[j+1]){//在两侧的
//                    if(cur[i] - below[j] <= 50){
//                        count++;
//                        break;
//                    }
                    if(below[j+1]-below[j] < 200){
                        count++;
                        break;
                    }
                }
                j++;
                //否则，不能固定住，舍弃当前
                cur[i] = -100;

            }
        }
        return count;
    }
}
