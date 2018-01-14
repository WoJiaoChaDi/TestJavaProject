package com.xudong.test;

public class TestEnum {

    //枚举
    enum FreshJuiceSize{ SMALL, MEDIUM, LARGE };
    FreshJuiceSize size;

    public static void main(String[] args) {
        //枚举：使用枚举可以减少代码中的bug
        TestEnum testEnum = new TestEnum();
        testEnum.size = TestEnum.FreshJuiceSize.SMALL;
        System.out.println(testEnum.size);
    }
}
