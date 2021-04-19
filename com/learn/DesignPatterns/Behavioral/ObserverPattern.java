package com.learn.DesignPatterns.Behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 随着观察对象的变化，观察者做出相应的反应。Kafka等发布订阅功能，就是用的“观察者模式”
 *
 * 观察者模式的主要角色如下。
 * 抽象主题（Subject）角色：也叫抽象目标类，它提供了一个用于保存观察者对象的聚集类和增加、删除观察者对象的方法，以及通知所有观察者的抽象方法。
 * 具体主题（Concrete Subject）角色：也叫具体目标类，它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
 * 抽象观察者（Observer）角色：它是一个抽象类或接口，它包含了一个更新自己的抽象方法，当接到具体主题的更改通知时被调用。
 * 具体观察者（Concrete Observer）角色：实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态。
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Subject sub = new ConcreteSubject();
        sub.add(new ConcreteObserver1("张三"));
        sub.add(new ConcreteObserver1("李四"));
        sub.add(new ConcreteObserver1("王五"));

        sub.notifyObserver();
    }

}

// 抽象对象
abstract class Subject{
    protected List<Observer> observers = new ArrayList<Observer>();

    public void add(Observer observer){
        this.observers.add(observer);
    }

    public void remove(Observer observer){
        this.observers.remove(observer);
    }

    // 通知观察值
    public abstract void notifyObserver();
}

//具体目标
class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        System.out.println("当前目标已经发生变化。");
        System.out.println("-------------------------------------");
        System.out.println("通知各个观察者。");
        for(Observer observer : this.observers){
            //  发布-订阅模式，还是使用的for循环，逐个通知。
            ((Observer)observer).request();
        }
    }
}

// 抽象观察者
interface Observer{
    void request();
}

//具体观察者1
class ConcreteObserver1 implements Observer {
    private String name;
    public ConcreteObserver1(String name){
        this.name = name;
    }
    @Override
    public void request() {
        System.out.println("类型1的观察者-" + this.name + ",已经收到通知。");
    }
}

//具体观察者2
class ConcreteObserver2 implements Observer {
    private String name;
    public ConcreteObserver2(String name){
        this.name = name;
    }
    @Override
    public void request() {
        System.out.println("类型2的观察者-" + this.name + ",已经收到通知。");
    }
}