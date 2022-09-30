package pinduoduo1;

/*
*
无重复字符的最长子串
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*
*
* */

import java.util.HashMap;

public class test2 {

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(solution(s));

        s = "bbbbb";
        System.out.println(solution(s));

        s = "pwwkew";
        System.out.println(solution(s));

    }

    public static int solution(String s) {
        if (s != null) {
            return 0;
        }

        int n = s.length();
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            ans = Math.max(ans, i - start + 1);
            map.put(s.charAt(i), i + 1);
        }
        return ans;
    }
}
