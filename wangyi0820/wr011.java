package wangyi0820;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Tdd
 * @creat 2022-08-26 19:10
 */
public class wr011 {
    public static void main(String[] args) {
        System.out.println(solution("bdaaadadb"));
        System.out.println(solution("abacb"));
        System.out.println(solution("zthtzh"));
        System.out.println(solution("abbbb"));
        System.out.println(solution("aba"));
        System.out.println("————————————");
        System.out.println(solution1("bdaaadadb"));
        System.out.println(solution1("abacb"));
        System.out.println(solution1("zthtzh"));
        System.out.println(solution1("abbbb"));
        System.out.println(solution1("aba"));
    }

    public static int solution(String s){
        int[] ch;
        int res = 0;
        for(int i = 0; i < s.length(); i++){//左边界
            ch = new int[26];
            ch[s.charAt(i) - 'a']++;
            for(int j = i + 1; j < s.length(); j++){//右边界
                ch[s.charAt(j) - 'a']++;
                if(judge(ch)) res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }

    public static boolean judge(int[] ch){
        for(int c : ch){
            if(c % 2 == 1) return false;
        }
        return true;
    }

    /*
    解法2  前缀和+状态压缩
        将 26 个字母出现次数的奇偶视为一种状态，一共有 2^26种状态，第 0 位为 1 表示 a 出现奇数次，第一位为 1 表示 b 出现奇数次
        而如果子串 [0，i] 与字串 [0,j] 状态相同，那么字串 [i+1,j] 的状态一定是 0，因此可以记录每个状态第一次出现的位置，此后再出现该状态时相减即可。
        需要注意状态 0 首次出现的位置应该设定为 -1。

        status 记录了遍历到当前下标 i 为tmp的情况，是一个前缀和的概念，并且是「异或前缀和」；
        重点：子串中出现偶数次，等价于：在这个子串里异或和为 0；
        由于要记录「最长的」符合要求的子串的长度，于是只需要记录第一次出现的「前缀异或和」，以后再次出现的相同的「异或前缀和」的时候，将下标相减（注意考虑边界情况）。
        参考：https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/solution/jian-dan-de-si-lu-by-mnizy/
     */
    public static int solution1(String S) {
        int n = S.length();
        HashMap<Integer, Integer> map = new HashMap<>();    // key：存储状态，value：代表某状态最早出现的位置
        int res = 0;
        int status = 0;         // 26位的二进制代表状态（一共2^26种状态，即每一位上都有可能是0or1），该位上为 0 代表出现偶数次
        map.put(0, 0);           // 状态为 0 、全部偶数次 最早出现在 前缀长度0 处

        char[] chars = S.toCharArray();
        for (int i = 0; i < n; i++) {           // 遍历字符串
            int tem = chars[i] - 'a';
            status ^= (1 << tem);               // 维护前缀状态

            int pre = map.getOrDefault(status, -1);     // 查找之前同状态的前缀长度，没有则为-1
            if (pre >= 0) {                     // 不为-1，之前有相同状态
                res = Math.max(res, i - pre + 1);
            } else {// pre为-1, 即当前状态status首次出现，进行记录
                map.put(status, i + 1);
                // map[status] = i + 1;
            }
        }
        return res;
    }
}





