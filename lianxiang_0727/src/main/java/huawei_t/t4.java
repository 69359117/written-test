package lianxiang_0727.src.main.java.huawei_t;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-14 21:41
 */
/*
3
abcdeba
aab
baab
 */
public class t4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        sc.nextLine();
        for (int i = 0; i < n; i++){
            str[i] = sc.nextLine();
            System.out.println(solution(str[i]) ? "Yes" : "No");
        }
    }

    public static boolean solution(String s){
        int count = 0;//操作偶数次则返回no
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = 1;
        while(j < sb.length()){
            if(sb.charAt(i) == sb.charAt(j)){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                count++;
                if(i > 0){
                    i--;
                    j--;
                }
            }else{
                i++;
                j++;
            }

        }
//        for (int i = 0, j = 1; j < sb.length(); i++, j++) {
//            if(sb.charAt(i) == sb.charAt(j)){
//                sb.deleteCharAt(i);
//                sb.deleteCharAt(i);
//                count++;
//                i--;
//                j--;
//                if(i > 0){
//                    i--;
//                    j--;
//                }
//            }
//        }
        return count%2 == 1;
    }
}
