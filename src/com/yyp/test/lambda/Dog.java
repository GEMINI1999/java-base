package com.yyp.test.lambda;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-25 下午 10:41
 * @Version 1.0
 */
public class Dog {
    // 昵称
    private String name;
    // 年龄
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
