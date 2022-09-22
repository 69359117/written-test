package lianxiang_0727.src.main.java.honor_t;

import java.util.*;

/**
 * @author Tdd
 * @creat 2022-09-22 19:43
 */


public class t3 {
    static class Stu implements Comparable {
        String name;
        int x, y, z;
        int sum;

        public int compareTo(Object o) {
            Stu as = (Stu) o;
            if (sum != as.sum) {
                return as.sum - sum;
            }
            if (x != as.x) {
                return as.x - x;
            }
            if (y != as.y) {
                return as.y - y;
            }
            if (z != as.z) {
                return as.z - z;
            }
            return name.compareTo(as.name);
        }
    }

    static Stu a[] = new Stu[10];

    static void print(int i) {
        System.out.println(a[i].name + " " + a[i].x + " " + a[i].y + " " + a[i].z);
    }

    static boolean check(int i) {
        return a[i].x >= 60 && a[i].y >= 60 && a[i].z >= 60;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s, tmp[];
        for (int i = 0; i < 10; i++) {
            s = scanner.nextLine();
            tmp = s.split(" ");
            a[i] = new Stu();
            a[i].name = tmp[0];
            a[i].x = Integer.parseInt(tmp[1]);
            a[i].y = Integer.parseInt(tmp[2]);
            a[i].z = Integer.parseInt(tmp[3]);
            a[i].sum = a[i].x + a[i].y + a[i].z;
        }
        Arrays.sort(a);
        System.out.println("[First round name list]");
        for (int i = 0; i < 10; i++) {
            if (check(i)) {
                print(i);
            }
        }
        System.out.println("");
        System.out.println("[Final name list]");
        print(0);
        int cnt = 1;
        for (int i = 1; i < 10; i++) {
            if (!check(i)) continue;
            if (a[i].x == a[i - 1].x && a[i].y == a[i - 1].y && a[i].z == a[i - 1].z) {
                print(i);
            } else {
                cnt++;
                if (cnt == 4) break;
                print(i);
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