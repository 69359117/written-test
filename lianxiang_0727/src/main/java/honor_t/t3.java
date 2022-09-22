package lianxiang_0727.src.main.java.honor_t;

import java.util.*;

/**
 * @author Tdd
 * @creat 2022-09-22 19:43
 */


public class t3 {
    static class Student implements Comparable {
        String name;
        int yuwen, math, english;
        int sum;

        public int compareTo(Object o) {
            Student other = (Student) o;
            if (sum != other.sum) {
                return other.sum - sum;
            }
            if (yuwen != other.yuwen) {
                return other.yuwen - yuwen;
            }
            if (math != other.math) {
                return other.math - math;
            }
            if (english != other.english) {
                return other.english - english;
            }
            return name.compareTo(other.name);
        }
    }

    static boolean check(int i) {
        return students[i].yuwen >= 60 && students[i].math >= 60 && students[i].english >= 60;
    }

    static void pr(int i) {
        System.out.println(students[i].name + " " + students[i].yuwen + " " + students[i].math + " " + students[i].english);
    }

    static Student students[] = new Student[10];

    public static void main(String[] args) {
        String s, tem[];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            s = scanner.nextLine();
            tem = s.split(" ");
            students[i] = new Student();
            students[i].name = tem[0];
            students[i].yuwen = Integer.parseInt(tem[1]);
            students[i].math = Integer.parseInt(tem[2]);
            students[i].english = Integer.parseInt(tem[3]);
            students[i].sum = students[i].yuwen + students[i].math + students[i].english;
        }
        Arrays.sort(students);
        System.out.println("[First round name list]");
        for (int i = 0; i < 10; i++) {
            if (check(i)) {
                pr(i);
            }
        }
        System.out.println("");
        System.out.println("[Final name list]");
//        pr(0);
//        int count = 1;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (!check(i)) continue;
            if(i==0){
                pr(i);
                count++;
                continue;
            }
            if (students[i].yuwen == students[i - 1].yuwen && students[i].math == students[i - 1].math && students[i].english == students[i - 1].english) {
                pr(i);
            } else {
                count++;
                if (count == 4) break;
                pr(i);
            }
        }
    }
}
/*
goudan2 60 80 80
zhaowu 60 80 80
zhangsan 60 80 80
yatou 90 80 80
goudan1 60 80 80
gousheng 80 100 60
lilei 80 100 60
hanmingmei 80 90 60
liutao 80 100 60
SimonYin 80 100 60
*/