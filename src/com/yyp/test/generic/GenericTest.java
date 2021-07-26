package com.yyp.test.generic;

import java.util.List;

/**
 * 泛型测试 generic
 * @Author Ying Yaopeng
 * @Date 2021-07-26 下午 10:10
 * @Version 1.0
 */

public class GenericTest {
    /**
     * 泛型方法
     * @param a 参数1
     * @param b 参数2
     * @param <T> 声明泛型
     * @return
     */
    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    /**
     * 泛型方法
     * @param c 泛型类对象
     * @param <T> 声明一个泛型
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
        T t = c.newInstance();
        return t;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 3));

        Point<String> p = new Point<>();
        p.setVar("yyp");
        System.out.println(p.getVar());
        System.out.println("========");

        Notepad<String, Integer> t = new Notepad<>();
        t.setKey("yyp");
        t.setValue(222);
        System.out.println(t.getKey() + " , " + t.getValue());
        System.out.println("========");

        Info<String> i = new InfoImpl<>();
        i.setVar("yyp1");
        System.out.println(i.getVar());

    }
}

/**
 * 泛型类
 * @param <T>
 */
class Point<T> {
    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}

/**
 * 泛型类
 * 此处指定了两个泛型类型
 */
class Notepad<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

/**
 * 泛型接口
 * @param <T>
 */
interface Info<T>{
    public T getVar();
    void setVar(T var);
}

class InfoImpl<T> implements Info<T>{
    private T var;
    @Override
    public void setVar(T var){
        this.var = var;
    }
    @Override
    public T getVar() {
        return this.var;
    }
}