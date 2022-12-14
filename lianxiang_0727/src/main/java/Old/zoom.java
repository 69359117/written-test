package Old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class zoom {

    public static void main(String[] args) {
//        HashSet<Object> names = new HashSet<>();
        HashMap<String, HashSet> names = new HashMap<>();
        HashSet<String> all = new HashSet<>();
        ArrayList<HashSet> hashSets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();          // 操作次数
        String[][] nums = new String[N][3];
        for (int i = 0; i < N; i++) {
            String kind = scanner.next();
            if( kind.equals("1") ){
                String name = scanner.next();
                HashSet<String> person = new HashSet<>();
                names.put(name,person);
                int count = Integer.parseInt(scanner.next());
                String[] focus = new String[count];
                for (int j = 0; j < focus.length; j++) {
                    focus[j] = scanner.next();
                }
                for (String s : focus) {
                    all.add(s);
                    person.add(s);
                }
                register(all,hashSets,name,count,focus);
            }else {
                String name = scanner.next();
                if(names==null || !names.containsKey(name)){
                    System.out.println("error");
                }else {
                    int result = find(names.get(name),hashSets);
                    System.out.println(result);
                }

            }

        }


    }


    public static void register(HashSet<String> all,ArrayList<HashSet> hashSets, String name , int count,String[] focus){
        HashSet tem = null;


        for (String s : focus) {
            if(!all.contains(s)){
                continue;
            }
            ArrayList<HashSet> removes = new ArrayList<HashSet>();
            for (HashSet hashSet : hashSets) {
                if(!hashSet.contains(s)){
                    continue;
                }
                if(tem == null){
                    tem = hashSet;
                }else {
                    tem.addAll(hashSet);
                }
                removes.add(hashSet);
//                hashSets.remove(hashSet);
            }
            for (HashSet remove : removes) {
                hashSets.remove(remove);
            }

        }

        if(tem == null){
            tem = new HashSet();
        }
        for (String s : focus) {
            tem.add(s);
        }
        hashSets.add(tem);

    }

    public static int find(HashSet person,ArrayList<HashSet> hashSets){

        for (Object o : person) {
            for (HashSet hashSet : hashSets) {
                if(!hashSet.contains(o)){
                    continue;
                }
                ArrayList<Object> result = new ArrayList<>();
                for (Object o1 : hashSet) {
                    if(!person.contains(o1)){
                        result.add(o1);
                    }
                }
                if(result==null){
                    return 0;
                }
                return result.size();
            }
        }
        return 0;
    }

}
