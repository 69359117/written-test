import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class zijie3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution(s);

    }


    public static void Solution(String s) {
        char[] chars = s.toCharArray();
        int avg = s.length()/4;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            Integer tem = map.getOrDefault(c, 0);
            map.put(c,tem+1);
        }
        HashMap<Character, Integer> plus = new HashMap<>();
//        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
//
//        }
    }
}
