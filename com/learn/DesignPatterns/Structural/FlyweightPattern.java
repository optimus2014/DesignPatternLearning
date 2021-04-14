package com.learn.DesignPatterns.Structural;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 * 应用场景：相同“对象”，只创建一次。和“单例模式”的区别，单例模式是一个类只创建一个对象，享元模式是一个类可以创建多个对象，相同熟悉的对象，只包含一个。
 * 例如系统中，有大量重复对象时。
 *
 * 享元模式其实是工厂方法模式的一个改进机制，享元模式同样要求创建一个或一组对象，并且就是通过工厂方法模式生成对象的，只不过享元模式为工厂方法模式增加了缓存这一功能。
 *
 * 包含内容：
 * 1.享元对象
 * 2.非享元对象：相同对象中，允许有不同的属性内容
 * 3.享元接口（抽象享元角色）
 * 4.享元工厂
 *
 * 享元模式是组织结构型设计模式
 */
public class FlyweightPattern {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory(); // 建设工厂
        Flyweight fw1 = factory.getFlyweight("a");
        Flyweight fw2 = factory.getFlyweight("a");
        Flyweight fw3 = factory.getFlyweight("b");
        Flyweight fw4 = factory.getFlyweight("b");

        fw1.operation(new UnsharedConcreteFlyweight("张三"));
        fw1.operation(new UnsharedConcreteFlyweight("李四"));
        fw1.operation(new UnsharedConcreteFlyweight("王五"));
        fw2.operation(new UnsharedConcreteFlyweight("张三"));
        fw3.operation(new UnsharedConcreteFlyweight("李四"));
        fw4.operation(new UnsharedConcreteFlyweight("王五"));
    }
}

// 抽象享元接口
interface Flyweight {
    // 非享元动作
    void operation(UnsharedConcreteFlyweight state);
}

// 非享元角色：单独属性
class UnsharedConcreteFlyweight {
    private String name;
    public UnsharedConcreteFlyweight(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


// 享元工厂:类似于工厂函数，只不过是包含容器，用于存储对象
class FlyweightFactory{
    Map<String,Flyweight> flyweights = new HashMap<String,Flyweight>();

    // 保障每个对象只有一个存在，使用Map容器存储
    public Flyweight getFlyweight(String name){
        if (!this.flyweights.containsKey(name)){
            this.flyweights.put(name,new ConcreteFlyweight(name));
        }
        return this.flyweights.get(name);
    }
}

// 具体的享元角色
class ConcreteFlyweight implements Flyweight{
    private String name;
    private int count = 0; // 记录被调用次数
    public ConcreteFlyweight(String name){
        this.name = name;
    }
    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        this.count += 1;
        this.show();
        System.out.println("对象非享元属性："+ state.getName());

    }

    private void show() {
        System.out.println("对象名称:" + this.name+",当前被调用次数：" + this.count);
    }


}