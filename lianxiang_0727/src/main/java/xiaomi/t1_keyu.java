//package lianxiang_0727.src.main.java.xiaomi;
//
//import java.util.*;
//
//
//public class t1_keyu {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Collection
//        List<int[]> list = new ArrayList<>();
//        while (sc.hasNext()) {
//            int[] tem = new int[2];
//            tem[0] = sc.nextInt();
//            tem[1] = sc.nextInt();
//            list.add(tem);
//        }
//
//        int[][] interval = list.toArray(new int[list.size()][2]);
//        Arrays.sort(interval, (o1, o2) -> o1[0] - o2[0]);
//
//        int ans = 0;
//        int[][] now = new int[list.size()][2];
//        int index = -1;
//        for (int[] ints : interval) {
//            if (index == -1 || ints[0] > now[index][1])  now[++index] = ints;
//            else now[index][1] = Math.max(now[index][1], ints[1]);
//        }
//
//        int[][] ints = Arrays.copyOf(now, index + 1);
//        for (int i = 0; i < ints.length; i++) {
//            ans += (ints[i][1] - ints[i][0]);
//        }
//
//        System.out.println(ans);
//    }
//}
