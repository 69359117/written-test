package lianxiang_0727.src.main.java;

import java.util.*;

/**
 * @author Tdd
 * @creat 2022-08-28 16:34
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//大臣数量
        int m = sc.nextInt();//重要性个数
        int help = sc.nextInt() - 1;//第i个大臣  下标是i-1
        int[][] important = new int[n][m];
        int[] sum = new int[n];
//        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2-o1);//从大到小
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                important[i][j] = sc.nextInt();
                sum[i] += important[i][j];
            }
            map.put(i, sum[i]);//key 第i个大臣  value 分数总和
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if( o2.getValue() != o1.getValue()) return o2.getValue() - o1.getValue();
                else return o1.getKey() - o2.getKey();
            }
        });

        int index = 0;
        while(list.get(index).getKey() != help){
            index++;
        }
        System.out.println(index+1);
    }
}
