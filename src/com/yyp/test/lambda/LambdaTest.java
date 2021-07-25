package com.yyp.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        dogList.add(new Dog("大黑", 6));
        dogList.add(new Dog("小红", 2));

        List<Dog> ret = dogList.stream().filter(dog -> dog.getAge() > 4).collect(Collectors.toList());
        List<Dog> ret1 = dogList.stream().filter(dog -> dog.getAge() <= 4).collect(Collectors.toList());
        print(ret);
        System.out.println("=====");
        List<Dog> ret2 = Stream.concat(ret.stream(), ret1.stream()).collect(Collectors.toList());
        print(ret2);
        System.out.println("=====");
        List<Dog> ret3 = Stream.of(new Dog("小黄", 5), new Dog("小黑", 4)).collect(Collectors.toList());
        print(ret3);
        System.out.println("=====");

        Stream.of("a", "b", "hello")
                .map(item-> item.toUpperCase())
                .forEach(System.out::println);
        System.out.println("=====");

        Stream.of(1, 2, 3)
                .flatMap(integer -> Stream.of(integer * 10))
                .forEach(System.out::println);
        System.out.println("=====");

        // 注意对象在使用distinct去重时需要重写equals方法
        Stream.of(1,2,3,1,2,3)
                .distinct()
                .forEach(System.out::println);
    }

    public static void print(List<Dog> list){
        for (Dog dog : list) {
            System.out.println(dog);
        }
    }
}
