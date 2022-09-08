import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-04 20:35
 */


public class t3_1 {
    public static String s, sub;
    public static int n, m;                         // n ：字符串长度 ， m：改动次数
    public static boolean check(int ans) {          // ans：窗口的二分
        int[]one = new int[26];                     // 出现次数
        int[]two = new int[26];                     // 是否允许改
        int zNum = 0;                               // zNum：不允许改的元素种类数
        for(int i = 0; i < n; ++i) {
            if(i >= ans) {                          // 窗口初始化完毕、滑动窗口
                int last = s.charAt(i - ans) - 'a';
                --one[last];
                if(sub.charAt(i - ans) == '0') {
                    if(--two[last] == 0) {
                        zNum -= 1;
                    }
                }
            }
            // 初始化窗口内的参数
            int cur = s.charAt(i) - 'a';            // cur ：当前字母-'a'
            ++one[cur];                             // 出现次数+1
            if(sub.charAt(i) == '0') {              // 调整不允许更改的次数
                if(++two[cur] == 1) {
                    zNum += 1;
                }
            }
            
            if(i >= ans - 1) {
                if(zNum == 0) {                     // 都允许更改
                    int mx = 0 ;
                    for(int j = 0; j < 26; ++j) {   // mx：出现频次最高的字母
                        mx = Math.max(mx, one[j]);
                    }
                    if(mx + m >= ans) {
                        return true;
                    }
                }
                
                if(zNum == 1) {                     // 有一个不允许更改，用它作为基准、进行修改能否满足
                    int idx = 0 ;
                    for(int j = 0; j < 26; ++j) {
                        if(two[j] > 0) {
                            idx = j;
                            break;
                        }
                    }
                    
                    if(one[idx] + m >= ans) {
                        return true;
                    }
                }
            }


        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();                   // 轮数
        while(T-- != 0) {
            n = sc.nextInt();                   // n：字符串长度
            m = sc.nextInt();                   // m：改动次数
            s = sc.next();                      // s：字符串
            sub = sc.next();                    // sub：是否允许改动
            int ansl = 1;                       // 左右窗口
            int ansr = n;
            while(ansl <= ansr) {
                int ansmid = (ansl + ansr) / 2; // ansmid：二分法、试探窗口长度
                if(check(ansmid)) {
                    ansl = ansmid + 1;
                }
                else {
                    ansr = ansmid - 1;
                }
            }
            System.out.println(ansr);
        }
    }
}