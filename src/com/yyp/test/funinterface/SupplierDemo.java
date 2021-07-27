package com.yyp.test.funinterface;

import java.util.function.Supplier;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-26 下午 10:46
 * @Version 1.0
 */
public class SupplierDemo {
    public static int getValue(Supplier<Integer> sup){
        try {
            return sup.get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        int value = getValue(() -> {
            return 3;
        });

        System.out.println(value);
    }
}
