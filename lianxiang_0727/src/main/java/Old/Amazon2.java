package Old;

import java.util.Scanner;



public class Amazon2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        System.out.println(Solution(num));

    }

    public static long Solution(long num){
        long ans = 0;
        if(num==1 || num == 2){
            return num;
        }
        Double tem = Math.sqrt(num);
        for (int i = 2; i <= num/2; i++) {
            while (num%i == 0){
                num = num / i;
                ans+=i;
            }
        }
        if(num>1){
            ans+=num;
        }


        return ans;
    }
}
