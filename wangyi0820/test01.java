package wangyi0820;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Tdd
 * @creat 2022-08-23 11:14
 *
 * 二叉树 两个节点  返回两个节点的距离
 */
public class test01 {

    public static void main(String[] args) {
        String s = "111";//input

    }

    //1.简单工厂类的实现
    private static Object createObject(String s){
        Object obj = null;
        if(s.equals("111")){
            obj = new HashMap<>();
        }else if(s.equals("222")){
            obj = new HashSet<>();
        }else{
            throw new RuntimeException("没有找到指定类型");
        }
        return obj;
    }

    //2.工厂方法类
    private static Object createObject2(String s){
        Factory objFactory = null;
        if(s.equals("111")){
            objFactory = new HashMapFactory();
        }else if(s.equals("222")){
            objFactory = new HashSetFactory();
        }else{
            throw new RuntimeException("没有找到指定类型");
        }

        Object obj = objFactory.creatObject();
        return obj;
    }
}

interface Factory{
    Object creatObject();
}

class HashMapFactory implements Factory{
    @Override
    public Object creatObject() {
        return new HashMap<>();
    }
}

class HashSetFactory implements Factory{
    @Override
    public Object creatObject() {
        return new HashSet<>();
    }
}
