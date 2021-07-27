package com.yyp.test.collect;

import java.util.*;

/**
 * @Author Ying Yaopeng
 * @Date 2021-07-27 下午 10:22
 * @Version 1.0
 */
public class CollectTest {
    public static void main(String[] args) {

        // 方法1
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "b", "d"));

        // 方法2
        ArrayList<String> list1 = new ArrayList<String>() {{
            add("a");
            add("b");
        }};

        // 方法3
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");

        // 方法4
        ArrayList<String> list3 = new ArrayList<String>(Collections.nCopies(3, "A"));

        HashSet<String> hs = new HashSet<String>(){
            {
                add("a");
                add("b");
            }
        };

        // 方法1
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "test");
        map.put("age", "20");

        // 方法2
        HashMap<String, String> map1 = new HashMap<String, String>() {
            {
                put("name", "test");
                put("age", "20");
            }
        };

//        for (int i = list.size() - 1; i >= 0; i--) {
//            if(("b").equals(list.get(i))) {
//                list.remove(i);
//            }
//        }
//        System.out.println(list);

//        for (String s : list) {
//            if(("b").equals(s)){
//                list.remove(s);
//            }
//        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String str = it.next();
            if(("b").equals(str)){
                it.remove();
            }
        }
        System.out.println(list);
    }

    public Integer test(Integer input){
        // 先进行拆箱
        int currentValue = input;
        // 业务处理
        for(int i = 0; i < 100; i++){
            currentValue += i;
        }
        // 返回结果，这里方法返回类型为Integer于是currentValue自动装箱返回
        return currentValue;
    }
}
