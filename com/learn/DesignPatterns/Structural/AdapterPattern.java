package com.learn.DesignPatterns.Structural;

/**
 * 适配器模式
 *
 * 包含：类适配器，对象适配器模式。
 * 其中类适配器使用类的继承关系，符合开闭原则
 * 对象适配器模式，需要客户端来创建“待适配类” 的对象
 */
public class AdapterPattern {
    public static void main(String[] args) {
        System.out.println("适配器模式执行中……");
        AdapterInterface oba = new ObjectAdapter(new Adapter());
        oba.request();

        AdapterInterface cla = new ClassAdapter();
        cla.request();
    }

}


interface AdapterInterface{
    void request();
}

// 待适配的类
class Adapter{
    protected void run(){
        System.out.println("适配者类执行中");
    }
}


// 类适配器
class ClassAdapter extends Adapter implements AdapterInterface{
    // 采用集成的方法，类耦合性更高，减少对象创建过程
    @Override
    public void request() {
        System.out.println("********** 类适配器调用中 **********");
        this.run();
    }
}

// 对象适配器
class ObjectAdapter implements AdapterInterface{
    private Adapter ad;
    protected ObjectAdapter(Adapter ad){
        this.ad = ad;
    }
    @Override
    public void request() {
        System.out.println("********** 对象适配器调用中 **********");
        this.ad.run();
    }
}