package Old;

import java.util.*;

/**
 * @author Tdd
 * @creat 2022-08-28 16:34
 */
public class t1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//总数
        int ans = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        for (int i = 0; i < n; i++) c[i] = sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i]>=b[i]) continue;
                if(a[i]*2 < b[j]) continue;
                for (int k = 0; k < n; k++) {
                    if(b[j] >= c[k])continue;
                    if(b[j]*2 <c[k])break;
                    ans++;
                }
            }
        }


        System.out.println(ans);
    }
}
