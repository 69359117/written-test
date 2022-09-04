package Old;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class sanliuling1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String s = scanner.nextLine();
            if(s.equals("")){
                break;
            }
            if(Huiwen(s) && Duichen(s)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }

    }

    public static boolean Huiwen(String s) {
        int length = s.length();
        for (int i = 0; i < length/2; i++) {
            if(s.charAt(i)!=s.charAt(length-i-1)){
                return false;
            }
        }

        return true;
    }

    public static boolean Duichen(String s) {
        HashSet<Character> characters = new HashSet<>();
        characters.add('A');
        characters.add('H');
        characters.add('I');
        characters.add('M');
        characters.add('O');
        characters.add('T');
        characters.add('U');
        characters.add('V');
        characters.add('W');
        characters.add('X');
        characters.add('Y');

        int length = s.length();
        for (int i = 0; i <= length/2; i++) {
            char c = s.charAt(i);
            if(!characters.contains(c)){
                return false;
            }
        }
        return true;
    }

}
