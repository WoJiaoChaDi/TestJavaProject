package com.xudong.test;

public class TestStatic {

    public static int numInstances = 0;//该类被实例化的次数
    public static int staticSize;
    public int normalSize;

    TestStatic(){
        staticSize = 2;
        normalSize = 2;

        this.addInstances();
    }

    private static void addInstances(){
        numInstances ++;
    }

    public static void main(String[] args) {

        //静态变量，所有类通用的变量
        TestStatic testStatic = new TestStatic();
        TestStatic normalStatic = new TestStatic();
        System.out.println(testStatic.staticSize);
        System.out.println(testStatic.normalSize);
        testStatic.staticSize = 3;
        testStatic.normalSize = 4;
        System.out.println(normalStatic.staticSize);
        System.out.println(normalStatic.normalSize);

        new TestStatic();
        new TestStatic();
        new TestStatic();
        new TestStatic();
        System.out.println(TestStatic.numInstances);
    }
}
