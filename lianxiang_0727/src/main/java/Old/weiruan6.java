package Old;

import java.util.Arrays;
import java.util.HashMap;

public class weiruan6 {

    public static void main(String[] args) {
        System.out.println(solution("bdaaadadb"));
        System.out.println(solution("abacb"));
        System.out.println(solution("zthtzh"));
        System.out.println(solution("abbbb"));
        System.out.println(solution("aba"));

    }

    public static int solution(String S) {
        // write your code in Java 8 (Java SE 8)
        int n = S.length();
        HashMap<Integer, Integer> map = new HashMap<>();    // key：存储状态，value：代表某状态最早出现的位置
        int res = 0;
        int status = 0;         // 26位的二进制代表状态，该位上为 0 代表出现偶数次
        map.put(0,0);           // 状态为 0 、全部偶数次 最早出现在 前缀长度0 处
        char[] chars = S.toCharArray();
        for (int i = 0; i < n; i++) {           // 遍历字符串
            int tem = chars[i] - 'a';
            status ^= (1 << tem);               // 维护前缀状态

            int pre = map.getOrDefault(status, -1);     // 查找之前同状态的前缀长度
            if (pre >= 0) {                     // 之前有相同状态
                res = Math.max(res, i - pre + 1);
            } else {
                // status 首次出现，进行记录
                map.put(status,i+1);
//                map[status] = i + 1;
            }
        }
        return res;
    }
}
