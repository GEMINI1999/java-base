package com.yyp.test.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-25 下午 10:40
 * @Version 1.0
 * 集合中的lambda表达式用法
 * 全部用法见 https://www.cnblogs.com/coprince/p/8692972.html
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("小黄", 5));
        dogList.add(new Dog("大黄", 6));
        dogList.add(new Dog("小黑", 4));
        dogList.add(new Dog("大黑", 6));
        dogList.add(new Dog("小红", 2));

        dogList.stream()


    }
}
