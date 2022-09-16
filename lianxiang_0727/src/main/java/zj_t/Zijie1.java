package zj_t;

import java.util.*;

//3
//5 2
//abcda
//01110
//7 2
//abbaccb
//1001001
//3 0
//aab
//101



public class Zijie1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int stringL = sc.nextInt();
            int fix = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            char[] ss = s.toCharArray();
            String canfix = sc.nextLine();
            int[] allows = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                allows[j] = canfix.charAt(j)-48;
            }
            solution(ss,allows,fix);
        }

    }


    public static void solution(char[] ss , int[] allows , int fix){
        int l = 0 , r = 0;
        int[] notfix = new int[26];         // 不允许改的字符的数量
        int numnotfix = 0;                  // 不允许改的字符种类数
        int[] nums = new int[26];           // 字符出现次数

        nums[ss[0]-'a']++;
        if(allows[0]==0){
            notfix[ss[0]-'a']++;
            numnotfix++;
        }
        int res = 1;
        while (r < ss.length-1){
            r++;
            char now = ss[r];
            nums[now-'a']++;
            if(allows[r]==0){
                if(notfix[now-'a']==0){
                    numnotfix++;
                }
                notfix[now-'a']++;
            }

            int length = r-l+1;
            boolean flag = false;

            // 不能改
            if( numnotfix > 2 ){
                flag = true;
            }else {
                flag = true;
                for (int i = 0; i < 26; i++) {
                    if( length > nums[i] + fix ||
                            (numnotfix == 1 && notfix[i] == 0 ) ){
                        continue;
                    }else {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                char out = ss[l];
                l++;
                nums[out-'a']--;
                if(allows[l]==0){
                    notfix[out-'a']--;
                    if(notfix[out-'a']==0){
                        numnotfix--;
                    }
                }
            }
        }
        System.out.println( (r - l + 1) );
    }
}
