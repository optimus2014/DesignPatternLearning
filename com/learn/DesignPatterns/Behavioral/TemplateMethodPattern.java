package com.learn.DesignPatterns.Behavioral;

/**
 * 模板方法模式
 * 属于行为型模式之一。
 * 定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。它是一种类行为型模式。
 * 设计一种“按部就班” 的流程
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        TemplateClass ob1 = new ConcreteClass1();
        TemplateClass ob2 = new ConcreteClass2();
        ob1.run();
        ob2.run();
    }
}

// 模板方法
abstract class TemplateClass{
    // 模板方法：用于串流程
    public void run(){
        this.specificMethod();
        this.abstractMethod();
    }

    private void specificMethod(){
        System.out.println("这是公共方法");
    }
    // 定义轴向方法
    protected abstract void abstractMethod();
}

// 特殊定义的对象
class ConcreteClass1 extends TemplateClass{

    protected void abstractMethod() {
        System.out.println("这是类型1的自有方法");
    }
}

// 特殊定义的对象
class ConcreteClass2 extends TemplateClass{

    protected void abstractMethod() {
        System.out.println("这是类型2的自有方法");
    }
}