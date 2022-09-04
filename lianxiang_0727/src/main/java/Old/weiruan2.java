package Old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class weiruan2 {

    public static void main(String[] args) {

//        System.out.println(sount("WRRWWR"));
//        System.out.println(sount("WWRWWWRWR"));
//        System.out.println(sount("WWW"));

        System.out.println(solution("WRRWWR"));
        System.out.println(solution("WWRWWWRWR"));
        System.out.println(solution("WWW"));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append("RW");
        }
        System.out.println(sount(String.valueOf(stringBuilder)));


    }

    public static int sount(String S ){

        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> reds = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='R'){
                reds.add(i);
            }
        }
        int size = reds.size();
        if(size==0 || size==1){
            return 0;
        }

        outer:for (int i = 0; i < size; i++) {
            int tem_ans = 0;
            int tem_mid = reds.get(i);
            // 前半部分
            int tem = tem_mid-1;
            for (int j = 0; j < i; j++) {
                tem_ans += (tem-reds.get(j));
                if(tem_ans > 1000000000){
                    continue outer;
                }
                tem--;
            }

            // 后半部分
            tem = tem_mid+1;
            for (int j = i+1; j < size; j++) {
                tem_ans += (reds.get(j)-tem);
                if(tem_ans > 1000000000){
                    continue outer;
                }
                tem++;
            }

            ans = Math.min(ans,tem_ans);
        }

        if(ans==Integer.MAX_VALUE){
            return -1;
        }

        return ans;

    }


//    public static int count2(String S ){
//        int ans = Integer.MAX_VALUE;
//        LinkedList<Integer> reds = new LinkedList<>();
//        for (int i = 0; i < S.length(); i++) {
//            if(S.charAt(i)=='R'){
//                reds.add(i);
//            }
//        }
//        int size = reds.size();
//        if(size==0 || size==1){
//            return 0;
//        }
//
//        int left = 0, right = size-1;
//        LinkedList<Integer> list_windows_white = new LinkedList<>();
//        LinkedList<Integer> pre = new LinkedList<>();
//        LinkedList<Integer> last = new LinkedList<>();
//        for (int i = 0; i < size; i++) {
//            if(S.charAt(i)=='W'){
//                list_windows_white.add(i);
//                reds.pop();
//            }
//        }
//        last = reds;
//
//
//
//
//    }

    public static int solution(String S){
        int n = S.length(), l = 0, idx = 0;
        long cnt = 0;
        int t = 1, sum = 0;
        long res = Long.MAX_VALUE;
        int[] pos = new int[n + 1];
        for(int i = 0; i < n; i++){
            if(S.charAt(i) == 'R'){
                pos[idx++] = i;         // pos：所有红色所在的位置
                sum++;                  // sum：红色总数
            }
        }
        if(sum == 0) return 0;
        int mid = sum >> 1;             // 中间位
        while(t < sum){
            cnt += (pos[l+t] - pos[l+t-1] - 1) * Math.min(t, sum - t++);
        }
        while(l + sum <= idx){
            res = Math.min(res, cnt);
            cnt -= pos[l+mid] - pos[l];
            cnt += pos[l+sum] - pos[l+sum-mid];
            l++;
        }
        if(res > 1000000000) return -1;
        return (int) res;
    }

}
