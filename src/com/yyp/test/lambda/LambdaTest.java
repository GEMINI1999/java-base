package com.yyp.test.lambda;

import java.util.*;
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
                .map(item -> item.toUpperCase())
                .forEach(System.out::println);
        System.out.println("=====");

        Stream.of(1, 2, 3)
                .flatMap(integer -> Stream.of(integer * 10))
                .forEach(System.out::println);
        System.out.println("=====");

        // 注意对象在使用distinct去重时需要重写equals方法
        Stream.of(1, 2, 3, 1, 2, 3)
                .distinct()
                .forEach(System.out::println);
        System.out.println("=====");

        Stream.of(1, 2, 3, 4, 5)
                .peek(integer -> System.out.println("accept:" + integer))
                .forEach(System.out::println);
        System.out.println("=====");

        Stream.of(1, 2, 3, 4, 5)
                //跳了6个元素，输出空stream
                .skip(6)
                //跳了2个元素，输出剩下的元素
//                .skip(2)
                .forEach(System.out::println);
        System.out.println("=====");

        Stream.of(1, 2, 3, 4, 5)
                //前两个元素
//                .limit(2)
                //全部元素
                .limit(6)
                .forEach(System.out::println);
        System.out.println("=====");

        Stream.of(5, 4, 3, 2, 1)
                .sorted()
                .forEach(System.out::println);
        System.out.println("=====");

        Stream.of(1, 2, 3, 4, 5)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("=====");

        dogList.stream().sorted(Comparator.comparing(Dog::getAge)).forEach(System.out::println);
        System.out.println("=====");

        // min中的是比较函数
        Optional<Integer> min = Stream.of(2, 1, 3, 5, 4)
                .min((o1, o2) -> o1 - o2);
        System.out.println("min:" + min.get());
        System.out.println("=====");

        boolean allMatch = dogList.stream().allMatch(dog -> dog.getAge() > 2);
        System.out.println("所有狗的年龄是否大于2:" + allMatch);
        System.out.println("=====");

        Optional<Integer> any = Stream.of(1, 2, 3, 4).findFirst();
        System.out.println(any.get());
        System.out.println("=====");

        Dog dogs = dogList.stream().findFirst().orElse(null);
        System.out.println(dogs);
        System.out.println("=====");

        // 都不满足条件才为true
        boolean noneMatch = dogList.stream().noneMatch(dog -> dog.getAge() > 1);
        System.out.println("所有狗的年龄是否都不大于1:" + allMatch);
        System.out.println("=====");
    }

    public static void print(List<Dog> list) {
        for (Dog dog : list) {
            System.out.println(dog);
        }
    }
}
