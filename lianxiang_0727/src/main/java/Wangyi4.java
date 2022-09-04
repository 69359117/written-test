import java.util.*;

public class Wangyi4 {

    static long anss = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(ints[i], list);
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
        solution(map);

    }


    public static void solution(HashMap<Integer, ArrayList<Integer>> map) {
        int N = 1000000000 + 7;
        long ans = 0;
        long tem = 1;

        for (int now : map.get(1)) {
            // 返回数组：子树乘积、
            long dfs = dfs(1, now, ans, map);
            anss = (anss + find(dfs)) % N;
            tem = (tem * dfs) ;
        }
        anss = (anss + find(tem)) % N;
        System.out.println(anss);
    }

    // 返回子树乘积
    public static long dfs(int from, int now, long ans, HashMap<Integer, ArrayList<Integer>> map) {
        int N = 1000000000 + 7;
        long tem = 1;
        if (map.get(now).size() == 1) {
            return now;
        }
        for (int i : map.get(now)) {
            if (i == from) {
                continue;
            }
            long dfs = dfs(now, i, ans, map);
            anss = (anss + find(dfs)) % N;
            tem = (tem * dfs) ;
//            ans = (ans + find(dfs)) % N;
//            tem = (tem * dfs);
        }
//        long[] longs = new long[2];
//        longs[0] = tem * now;
//        longs[1] = ans;
        return tem * now;
    }


    public static long find(long num) {
        long ans = 0;
        int N = 1000000000+7;
        for (long i = 1; i <=num; i++) {
            if (num % i == 0) {
                ans = (ans + 1) % N;
            }
        }
        return ans;
    }
}