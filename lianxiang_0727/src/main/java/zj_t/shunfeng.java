package zj_t;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

//5 3
//1 2 3 4 5

//5 4
//1 2 3 4 5

//5 1
//1 2 3 4 5

//10 9
//1 19 13 4 16 12 5 8 14 6


public class shunfeng {

    public static void main(String[] args) {
//        new StringBuilder().toString()
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();           // 种类数
        int m = sc.nextInt();           // 套题需要种类数
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < n; i++) {
            queue.add( sc.nextInt() );
        }
        System.out.println(solution(queue, m));
    }

    public static int solution(PriorityQueue<Integer> queue , int m){
        int ans = 0;
        while (queue.size() >= m){
            int[] ints = new int[m];
            for (int i = 0; i < m; i++) {
                ints[i] = queue.poll();
            }
            int min = Integer.MAX_VALUE;
            if(queue.size()>=1){
                min = queue.peek() ;
            }
            int tem = Math.max(1,ints[m-1]-min);
            ans += tem;
            for (int i = 0; i < m-1; i++) {
                if(ints[i]!=tem){
                    queue.add(ints[i]-tem);
                }
            }
        }
        return ans;
    }
}