package lianxiang_0727.src.main.java.xiaomi;

/**
 * @author Tdd
 * @creat 2022-09-21 19:22
 */
public class t3 {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        boolean flag = true;
        while(true){
            if(index >= strs[0].length()) break;
            char c = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++){
                if(index >= strs[i].length() || strs[i].charAt(index) != c){
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
            index++;
        }
        return strs[0].substring(0, index);
    }
}
