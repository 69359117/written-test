import java.util.Scanner;

public class dajiang {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        char[] split = s.toCharArray();
        int N = s.length();
        if(N<3){
            System.out.println(0);
        }

        if(N%2==1){         // 奇数，不能浪费
            int[] count = count(split, 0, N-1);
            System.out.println((count[0] + Math.min(count[1], count[2])));
        }else {
            int[] count1 = count(split, 1, N-1);
            int tem1 = count1[0] + Math.min(count1[1], count1[2]);
            int[] count2 = count(split, 0, N-2);
            int tem2 = count2[0] + Math.min(count2[1], count2[2]);
            int ans = Math.min(tem1,tem2);          // 放弃首尾的最小消耗
            if(N >= 6){
                count1 = count(split, 0, 2);
                count2 = count(split, 3, N-1);
                tem1 = count1[0] + Math.min(count1[1], count1[2]);
                tem2 = count2[0] + Math.min(count2[1], count2[2]);
                int tem = tem1+tem2;
                ans = Math.min(ans,tem);
                for (int i = 3; i < N-3 ; i+=2) {
                    // 第 i、i+1 个从后段加到前段
                    // 处理 i；
                    if(split[i]!='e'){
                        count1[0]++;
                    }
                    if( (i-3)%4 == 0 ){
                        if(split[i] == 'r'){
                            count2[2]--;
                        }else if(split[i] == 'd'){
                            count2[1]--;
                        }else {
                            count2[1]--;
                            count2[2]--;
                        }
                    }else {
                        if(split[i] == 'r'){
                            count2[1]--;
                        }else if(split[i] == 'd'){
                            count2[2]--;
                        }else {
                            count2[2]--;
                            count2[1]--;
                        }
                    }

                    // 处理 i+1
                    if(split[i+1]!='e'){
                        count2[0]--;
                    }

                    if( (i+1) % 4 ==0 ){
                        if(split[i+1] == 'r'){
                            count1[2]++;
                        }else if(split[i+1] == 'd'){
                            count1[1]++;
                        }else {
                            count1[2]++;
                            count1[1]++;
                        }
                    }else {
                        if(split[i+1] == 'r'){
                            count1[1]++;
                        }else if(split[i+1] == 'd'){
                            count1[2]++;
                        }else {
                            count1[2]++;
                            count1[1]++;
                        }
                    }
                    tem1 = count1[0] + Math.min(count1[1], count1[2]);
                    tem2 = count2[0] + Math.min(count2[1], count2[2]);
                    tem = tem1+tem2;
                    ans = Math.min(ans,tem);
                }
            }
            System.out.println(ans);
        }

    }


    // 改造 String s 的 [l , r] 的代价
    public static int[] count(char[] chars, int l , int r) {
        if(r-l<2){
            return new int[] {0,0,0};
        }
        int res = 0;
        // 1、3、5 处 的 e 的代价
        for (int i = l+1; i <= r; i+=2) {
            if(chars[i]!='e'){
                res++;
            }
        }

        // 假设以 r 开头，需要的代价
        int res_r = 0,res_d = 0;

        for (int i = l; i <= r; i+=4) {
            if(chars[i]!='r'){
                res_r++;
            }
            if (chars[i]!='d'){
                res_d++;
            }
        }
        for (int i = l+2; i <= r; i+=4) {
            if(chars[i]!='d'){
                res_r++;
            }
            if (chars[i]!='r'){
                res_d++;
            }
        }
        return new int[] {res,res_r,res_d};
    }
}
