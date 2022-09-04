package JD0903;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-03 19:50
 */
public class t3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {//左侧i从0~n-2
            for (int j = i + 1; j < s.length(); j++) {//右侧从i+1~n-1
                String sub = s.substring(i, j+1);
                int temp = solution(sub);
                ans += temp;
            }
        }
        System.out.println(ans);
    }

    //求子串sub的权重（最长合法 子序列 长度）
    public static int solution(String sub) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < sub.length(); i++) {
            if(sub.charAt(i) == '(') stack.push(i);
            else if(!stack.isEmpty() && sub.charAt(i) == ')'){
                stack.pop();
                sum += 2;
            }
        }
        return sum;
    }
}


//    //求子串sub的权重（最长合法子序列长度）
//    public static int solution(String sub){
//        Deque<Integer> stack = new ArrayDeque<>();
//        int[] arr = new int[sub.length()];
//        for (int i = 0; i < sub.length(); i++) {
//            if(sub.charAt(i) == '(') stack.push(i);
//            else{
//                if(stack.isEmpty()) arr[i] = 1;
//                else stack.pop();
//            }
//        }
//        while (!stack.isEmpty()) arr[stack.pop()] = 1;
//
//        int count = 0, max = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] == 0) count++;
//            else count = 0;
//            max = Math.max(count, max);
//        }
//        return max;
//    }