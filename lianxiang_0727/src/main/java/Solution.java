

public class Solution {

    public static void main(String[] args) {
        "aba".charAt(0);
        System.out.println(isEquals("aba", "aab"));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 比较给定的两个字符串是否相等
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return bool布尔型
     */
    public static boolean isEquals(String str1, String str2) {
        // write code here

        int[] ints = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            ints[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            ints[str2.charAt(i) - 'a']--;
        }
        for (int anInt : ints) {
            if (anInt != 0) {
                return false;
            }
        }
        return true;
    }
}
