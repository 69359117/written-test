import java.util.Arrays;
import java.util.Scanner;

//5
//1 3 2 4 5


public class ali {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }

        Solution(ints);

    }


    public static void Solution(int[] ints) {

        Arrays.sort(ints);
        // n : 设最终、所有值改写为 n、n+1
        int n = 1;
        // l：最后小于 n 的值的数组下标 ； r：首个大于 n+1 的值的数组下标
        int l = -1 , r = ints.length;
        for (int i = 0; i < ints.length; i++) {
            if(ints[i] < n){
                l++;
            }else if (ints[i] > n+1){
                r = i;
                break;
            }
        }
        long ans = 0;
        for (int i = 0; i <= l; i++) {
            ans += (n - ints[i]);
        }
        for (int i = r; i < ints.length; i++) {
            ans += ints[i] - (n+1);
        }
        long tem = ans;
        n++;
        for (; n <= ints[ints.length-1]; n++) {
            while (l+1<ints.length && ints[l+1]<n){
                l++;
            }
            tem += l+1;
            while (r+1 < ints.length && ints[r+1] <= (n+1) ){
                r++;
            }
            tem -= (ints.length - r);
            ans = Math.min(ans,tem);
        }
        System.out.println(ans);

    }

}
