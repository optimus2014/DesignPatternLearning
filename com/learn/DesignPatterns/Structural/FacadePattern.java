package com.learn.DesignPatterns.Structural;

/**
 * 外观模式：
 * 定义一个客户端，作为统一的“对外服务者”
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade f = new Facade();
        f.method();
    }
}


class Facade{
    SubFacade1 sf1 = new SubFacade1();
    SubFacade2 sf2 = new SubFacade2();
    public void method(){
        sf1.run();
        System.out.println("外观模式随便修饰");
        sf2.run();
    }
}

class SubFacade1{
    public void run(){
        System.out.println("这是第一个子类的方法");
    }
}

class SubFacade2{
    public void run(){
        System.out.println("这是第二个子类的方法");
    }
}