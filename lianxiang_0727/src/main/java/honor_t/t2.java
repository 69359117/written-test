package lianxiang_0727.src.main.java.honor_t;

import java.util.*;

/**
 * @author Tdd
 * @creat 2022-09-22 20:09
 */
public class t2 {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();//默认是按key升序——————
        map.put("a", 1);
        map.put("c", 2);
        map.put("d", 4);
        map.put("b", 3);

        //接下来是按value升序——————————————————————————————
        //这里将map.entrySet()转换成list
        List<Map.Entry> list = new ArrayList<>(map.entrySet());

        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator <Map.Entry>() {
            //升序排序
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (Integer)o1.getValue() - (Integer)o2.getValue();
            }
        });

        for(Map.Entry mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }

}
