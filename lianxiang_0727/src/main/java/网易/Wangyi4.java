package 网易;

import java.util.*;
//
//3
//1 2 3
//1 2
//1 3

//4
//1 2 3 4
//1 2
//1 3
//2 4

//4
//2 3 4 5
//1 2
//1 3
//2 4

public class Wangyi4 {

    static long ress = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] power = new int[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i+1, list);
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(map.get(a)==null){
                System.out.println(0);
                return;
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        solution(map,power);

    }


    public static void solution(HashMap<Integer, ArrayList<Integer>> map,int[] power ) {
        int N = 1000000000 + 7;
        long res = 0;
        long tem = 1;

        for (int now : map.get(1)) {
            // 返回：子树权值乘积
            long dfs = dfs(1, now, map,power);
            ress = (ress + find(dfs)) % N;
            tem = (tem * dfs) ;
        }
        tem *= power[0];
        ress = (ress + find(tem)) % N;
        System.out.println(ress);
    }

    // 返回子树乘积
    public static long dfs(int from, int now, HashMap<Integer, ArrayList<Integer>> map,int[] power) {
        int N = 1000000000 + 7;
        long tem = 1;
        if (map.get(now).size() == 1) {
            return power[now-1];
        }
        for (int i : map.get(now)) {
            if (i == from) {
                continue;
            }
            long dfs = dfs(now, i, map,power);
            ress = (ress + find(dfs)) % N;
            tem = (tem * dfs) ;
        }
        return tem * power[now-1];
    }


    public static long find(long num) {
        long res = 0;
        int N = 1000000000+7;
        for (long i = 1; i <=num/2; i++) {
            if (num % i == 0) {
                res++;
            }
        }
        if(num!=1){
            res++;
        }
        return res;
    }
}