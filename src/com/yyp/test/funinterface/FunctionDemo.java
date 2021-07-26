package com.yyp.test.funinterface;

import java.util.function.Function;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-26 下午 10:54
 * @Version 1.0
 */
public class FunctionDemo {
    public static String convert(String str,
                                 Function<String, String> fun1,
                                 Function<String, Integer> fun2,
                                 Function<Integer, String> fun3) {

        return fun1.andThen(fun2).andThen(fun3).apply(str);
    }

    public static void main(String[] args) {
        String str = convert("迪丽热巴,23", (s) -> {
            return s.split(",")[1];
        }, (s) -> {
            return Integer.parseInt(s) + 100;
        }, (s) -> {
            return String.valueOf(s);
        });
        System.out.println(str);
    }
}
