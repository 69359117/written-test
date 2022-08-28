import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Amazon2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        List<Integer> parcels = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            parcels.add(sc.nextInt());
        }

        int k = sc.nextInt();
        System.out.println(getMinimumCost(parcels, k));

    }

    public static int getMinimumCost(List<Integer> parcels, int k){
        int ans = 0;
        if(k <= parcels.size()){
            return 0;
        }
        int remain = k-parcels.size();
        HashSet<Integer> integers = new HashSet<>();
        for (Integer parcel : parcels) {
            integers.add(parcel);
        }
        int res = k - parcels.size();
        for (int i = 1; i <= k; i++) {
            if(!integers.contains(i)){
                res--;
                ans+=i;
                if(res==0){
                    break;
                }
            }
        }
        return ans;

    }

}
