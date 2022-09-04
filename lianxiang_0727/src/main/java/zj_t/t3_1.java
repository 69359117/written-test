package lianxiang_0727.src.main.java.zj_t;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-04 20:35
 */


public class t3_1 {
    public static String s, sub;
    public static int n, m;
    public static boolean check(int ans) {
        int[]one = new int[26];
        int[]two = new int[26];
        int zNum = 0;
        for(int i = 0; i < n; ++i) {
            if(i >= ans) {
                int last = s.charAt(i - ans) - 'a';
                --one[last];
                if(sub.charAt(i - ans) == '0') {
                    if(--two[last] == 0) {
                        zNum -= 1;
                    }
                }
            }
            int cur = s.charAt(i) - 'a';
            ++one[cur];
            if(sub.charAt(i) == '0') {
                if(++two[cur] == 1) {
                    zNum += 1;
                }
            }
            
            if(i >= ans - 1) {
                if(zNum == 0) {
                    int mx = 0 ;
                    for(int j = 0; j < 26; ++j) {
                        mx = Math.max(mx, one[j]);
                    }
                    if(mx + m >= ans) {
                        return true;
                    }
                }
                
                if(zNum == 1) {
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
        int T = sc.nextInt();
        while(T-- != 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            s = sc.next();
            sub = sc.next();
            int ansl = 1;
            int ansr = n;
            while(ansl <= ansr) {
                int ansmid = (ansl + ansr) / 2;
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