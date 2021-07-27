package com.yyp.test.equals;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-25 下午 3:59
 * @Version 1.0
 */
public class EqualsTest {
    public static void main(String[] args) {
        /**
         * “equals”比较
         * 1. 基本类型(值类型)之间无法使用equals比较。
         * 2. equals参数为值类型，则参数会进行自动装箱为包装类型，之后请参见第3点。
         * 3. equals参数为包装类型，则先比较是否为同类型，非同类型直接返回false，同类型再比较值。
         */
        // false
        System.out.println(new Long(0).equals(0));
        // true
        System.out.println(new Integer(500).equals(500));
        // false
        System.out.println(new Integer(500).equals((short)500));
        // true
        System.out.println(new Long(0).equals(0L));

        System.out.println(new Long(500).equals(500));

        System.out.println("===========================");

        /**
         * “==”比较
         * 1. 基本类型之间互相比较：以值进行比较
         * 2. 一边是基本类型，一边是包装类型
         *     1) 同类型的进行比较，如Integer 与int，Long与long进行==比较时，会自动拆箱比较值
         *     2) 不同类型之间进行比较，则会自动拆箱，且会进行自动向上转型再比较值（低级向高级是隐式类型转换如：byte<short<int<long<float<double，高级向低级必须强制类型转换）
         * 3. 两边都是包装类型则直接比较引用地址，但是要注意IntegerCache除外。
         */
        int a = 0;
        System.out.println(new Integer(0) == 0);


        Integer i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        Integer i05 = 127;
        Integer i06 = Integer.valueOf(127);
        Integer i07 = 128;
        Integer i08 = Integer.valueOf(128);

        System.out.println(i02 == i03);  // true
        System.out.println(i02 == i04);  // false
        System.out.println(i03 == i04);  // false

        System.out.println("===================");

        System.out.println(i05 == i06);
        System.out.println(i07 == i08);

    }
}
