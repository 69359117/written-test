import java.util.ArrayList;

public class weiruan2 {

    public static void main(String[] args) {

        System.out.println(sount("WRRWWR"));
        System.out.println(sount("WWRWWWRWR"));
        System.out.println(sount("WWW"));

    }

    public static int sount(String S ){

        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> reds = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='R'){
                reds.add(i);
            }
        }
        int size = reds.size();
        if(size==0 || size==1){
            return 0;
        }

        for (int i = 0; i < size; i++) {
            int tem_ans = 0;
            int tem_mid = reds.get(i);
            // 前半部分
            int tem = tem_mid-1;
            for (int j = 0; j < i; j++) {
                tem_ans += (tem-reds.get(j));
                tem--;
            }


            // 后半部分
            tem = tem_mid+1;
            for (int j = i+1; j < size; j++) {
                tem_ans += (reds.get(j)-tem);
                tem++;
            }

            ans = Math.min(ans,tem_ans);

        }
        return ans;

    }

}
