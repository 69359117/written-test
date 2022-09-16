package lianxiang_0727.src.main.java.mayi_t;

import java.util.ArrayList;
import java.util.Scanner;


// ababa

public class t3 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        findOne(str);
    }


    public static void findOne(String s) {
        long res = 0;
        int onesdeD = 0;
        int[] lastOne = new int[s.length() + 1];
        lastOne[0] = onesdeD;//初始化

        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(i) - 'a';
            onesdeD = onesdeD ^ 1 << (now);

            lastOne[i + 1] = onesdeD;

            for (int j = 0; j <= i; j++) {
                int oneTe = lastOne[j];
                oneTe = oneTe ^ onesdeD;
                if (oneTe != 0 && (oneTe & (oneTe - 1)) == 0) res++;
            }
        }
        System.out.println(res);
    }
}
