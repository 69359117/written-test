package lianxiang_0727.src.main.java.keyu_zj;

import javax.xml.stream.events.Characters;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Tdd
 * @creat 2022-09-19 11:02
 */
//public class test {
//    public static void main(String[] args) {
//
//    }
//
//    public void solution(){
//        ArrayList<Integer> list = new ArrayList<>();
//
//    }
//}

//public class test {
//    public static void main(String[] args) throws Exception {
//        List<Integer> list = new ArrayList<>(); //定义Integer泛型
//        String str = "abc";
//        Method[] method=list.getClass().getMethods();//取得list的所有方法
//        System.out.println(method.length);
//        for(int i=0;i<method.length;i++){
//            System.out.println(method[i]);//遍历打印list的方法
//        }
//
//        //通过反射来执行list的第一个方法,第一个是list对象,代表该对象的方法,第二个是方法参数:  就是list.add(str);
//        method[0].invoke(list, str);
//
//        System.out.println("添加后的集合大小"+list.size());
//        for(int i=0;i<list.size();i++){//打印结果
//            System.out.println(list.get(i));
//        }
//    }
//}

//
//public class test {
//    public static void main(String[] args) throws Exception {
//        String s = "weo  w cc";
//        String s1 = " WEO  W CC";
//        System.out.println(solution(s));
//        System.out.println(solution(s1));
//    }
//
////    public void solution(int N){
////        List<Integer> list = new ArrayList<>();
////        for (int i = 0; i < 64; i++) {//1~64号加入list
////            list.add(i+1);
////        }
////
////        int i = 0;
////        while(i < N){//N轮
////            int num = 0;
////            while(num < list.size()){
////                if(num % 5 == 0) list.remove(num);
////                num++;
////            }
////            i++;
////        }
////
////        //打印留下来的
////        for (int j = 0; j < list.size(); j++) {
////            System.out.println(list.get(i));
////        }
////    }
//
//    public static String solution(String s) {
//        if (s.length() == 0) return s;
//
//        int i = 0;
//        while (i < s.length()) {
//            if (Character.isLetter(s.charAt(i)) && Character.isLowerCase(s.charAt(i))) return s.toUpperCase();
//            if (Character.isLetter(s.charAt(i)) && Character.isUpperCase(s.charAt(i))) return s.toLowerCase();
//            i++;
//        }
//        return "";
//    }
//}


public class test {

    Calendar c = new GregorianCalendar();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public void calcBirthDay() {
        System.out.println("请输入生日，请输入一个固定的格式");
        System.out.println("例如：10-21");
        String input = scanner.next();
        String[] inputs = input.split("-");
        int month = Integer.parseInt(inputs[0]);
        int day = Integer.parseInt(inputs[1]);
        int year = c.get(Calendar.YEAR);
        Calendar birthday = new GregorianCalendar();
        birthday.set(year, month - 1, day);
        int last = birthday.get(Calendar.DAY_OF_YEAR);
        int first = c.get(Calendar.DAY_OF_YEAR);
        int days = c.getActualMaximum(Calendar.DAY_OF_YEAR);
        if (birthday.after(c)) {
            int m = last - first;
            System.out.println("距离他/她过生日还有" + m + "天");
        } else {
            int m = last - first;
            m = Math.abs(m);
            System.out.println("她/他的生日已经过去了");
            Calendar nextbirthday = new GregorianCalendar();
            nextbirthday.set(year + 1, month - 1, day);
            int sday = days - last + nextbirthday.get(Calendar.DAY_OF_YEAR);
            System.out.println("但是距离下一个生日还有" + sday + "天");
        }
    }

    public static int addDigits(int num) {
        int sum = 0;
        while (num > 9) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;//加上最后一位

        if (sum < 10) {
            return sum;
        } else {
            return addDigits(sum);
        }
    }
}
