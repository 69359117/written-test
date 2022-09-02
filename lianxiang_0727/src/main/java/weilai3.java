//import java.io.Externalizable;
//import java.io.Serializable;
//import java.util.*;
//
//public class weilai3 implements Externalizable {
//
//    public static void main(String[] args) {
//        new HashMap<>().put("123",null);
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        LinkedList<Integer> integers = new LinkedList<>();
//        for (int i = 1; i <= N; i++) {
//            integers.add(i);
//        }
//        int num = scanner.nextInt();
//        Character[] c = new Character[num];
//        scanner.nextLine();
//        for (int i = 0; i < num; i++) {
//            c[i] = scanner.nextLine().charAt(0);
//        }
//        solution(integers, c);
//
//    }
//
//    public static void solution(LinkedList<Integer> integers,Character[] c){
//        boolean flag = true;
//        for (Character character : c) {
//            if(character=='A'){
//                if(flag){
//                    integers.addLast(integers.pop());
//                }else {
//                    integers.addFirst(integers.pollLast());
//                }
//            }else {
//                flag = !flag;
//            }
//        }
//        int size = integers.size();
//        if(flag){
//            for (int i = 0; i < size; i++) {
//                System.out.println(integers.pollFirst());
//            }
//        }else {
//            for (int i = 0; i < size; i++) {
//                System.out.println(integers.pollLast());
//            }
//        }
//    }
//
//}
