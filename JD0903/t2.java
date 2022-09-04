package JD0903;

import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-03 18:56
 */
public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += solution(arr[i]);
        }
        System.out.println(res);
//        System.out.println(solution(2));
//        System.out.println(solution(4));//少1
//        System.out.println(solution(3));//2
//        System.out.println(solution(4));//3
    }

    public static long solution(int n){
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(isPrime((n))){
            return 1 + solution(n-1);
        }
        int temp = 0;
        for (int i = (n/2+1); i >= 2; i--) {
            if(n % i == 0) temp = i;
        }
        return 1 + solution(temp) + solution(n/temp);
    }

    public static boolean isPrime(int num){
        boolean flag = true;
        for (int i = 2; i <= num/2; i++) {
            if(num % i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
