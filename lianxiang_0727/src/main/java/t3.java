import java.util.ArrayList;
import java.util.Scanner;


// ababa

public class t3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solution(s);
    }


    public static void solution(String s) {
        long ans = 0;
        // false 表示该字母为偶数
        boolean[] flags = new boolean[26];
        ArrayList<boolean[]> pres = new ArrayList<>();
        pres.add(new boolean[26]);
        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(0)-'a';
            flags[now] = !flags[now];
            boolean[] nowFlags = new boolean[26];
            for (int j = 0; j < 26; j++) {
                nowFlags[j] = flags[j];
            }
            pres.add(nowFlags);
            for (int j = 0; j <= i; j++) {
                boolean[] tem = pres.get(j);
                int sum = 0;
                for (int k = 0; k < 26; k++) {
                    if( tem[k] ^ flags[k] ){
                        if(sum!=0){
                            sum++;
                            break;
                        }else {
                            sum++;
                        }
                    }
                }
                if(sum==1){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
