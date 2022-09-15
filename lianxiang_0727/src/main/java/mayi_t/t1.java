
import java.util.Scanner;

/**
 * @author Tdd
 * @creat 2022-09-15 19:22
 */
public class t1 {
    public static void main(String[] args) {
        int[] nums = new int[26];
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        nums[0] = input;
        for (int i = 0; i < 25; i++) {
            while(nums[i] > 1){
                nums[i+1]++;
                nums[i] = nums[i] - 2;
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while(nums[i] > 0){
                s.append(Character.toChars(i +'a'));
                nums[i]--;
            }
        }
        System.out.println(s);
    }
}
