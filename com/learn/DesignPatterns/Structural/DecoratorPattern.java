package com.learn.DesignPatterns.Structural;

/**
 * 装饰器模式
 * 装饰器模式主要包含以下角色。
 * 抽象构件（Component）角色：定义一个抽象接口以规范准备接收附加责任的对象。
 * 具体构件（ConcreteComponent）角色：实现抽象构件，通过装饰角色为其添加一些职责。
 * 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 * 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 *
 * 修饰的方法，会多层嵌套，多次展示。
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        System.out.println("开始测试装饰器模式");
        Component comp = new ConcreteComponent();
        comp.operate();

        Component compDecorator = new ConcreteDecorator(comp);
        compDecorator.operate();

        Component compd1 = new ConcreteDecorator(compDecorator,"手柄");
        compd1.operate();
        Component compd2 = new ConcreteDecorator(compd1,"扩展坞");
        compd2.operate();
    }
}

// 抽象构件接口(定义实际角色和装饰器角色的规范)
interface Component{
    void operate();
}

// 具体构建
class ConcreteComponent implements Component{
    public ConcreteComponent(){
        System.out.println("创建具体构件角色");
    }

    @Override
    public void operate() {
        System.out.println("创建一个Switch.");
    }
}
// 抽象装饰器
class Decorator implements Component{
    private Component comp;
    protected Decorator(Component comp){
        this.comp = comp;
    }
    @Override
    public void operate() {
        comp.operate();
    }
}

// 具体装饰器类
class ConcreteDecorator extends Decorator{
    private String tab;
    protected ConcreteDecorator(Component comp) {
        super(comp);
    }
    protected ConcreteDecorator(Component comp,String tab) {
        super(comp);
        this.tab = tab;
    }
    public void operate(){
        this.preDecorator();
        super.operate();
    }

    private void preDecorator(){
        if (this.tab == null){
            System.out.println("装饰器开始工作啦!");
        } else {
            System.out.println("这就是装饰器装饰的东东，装饰一个：" + this.tab);
        }
    }
}