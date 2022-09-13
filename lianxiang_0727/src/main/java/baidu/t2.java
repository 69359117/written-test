package baidu;

import java.util.Scanner;

//5
//2 3 4 2 3

//6
//1 1 2 3 2 3

//6
//3 6 9 1 1 1

//6
//2 4 6 1 1 1

//6
//4 8 12 1 1 1

//6
//4 8 13 1 1 1

public class t2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int[] ints = new int[i];
        for (int n = 0; n < i; n++) {
            ints[n] = sc.nextInt();
        }
        solution(ints);

    }

    public static void solution(int[] ints){
        int sum = 0;
        int i = 0;
        while (i < ints.length) {
            if(ints[i] == 0){
                i++;
                continue;
            }
            if(i < ints.length-2 && ints[i]>=1 && ints[i+1] >=2 && ints[i+2] >=3){
                int left = 2 , right = 1000000000;

                while ( left < right ){
                    int mid = (left+right)/2;
                    if(ints[i]>=mid && ints[i+1] >=2*mid && ints[i+2] >=3*mid){         // 满足
                        left = mid+1;
                    }else {
                        right = mid;
                    }
                }
                left--;
                sum+=5*left;
                ints[i]-=left;
                ints[i+1]-=2*left;
                ints[i+2]-=3*left;
            }
            sum += ints[i];
            i++;
        }
        System.out.println(sum);
    }
}
